package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;
import com.etoak.exception.ET1911LoginException;
import com.etoak.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
UserService userService;
	
	@GetMapping("/getUserById")
	@ResponseBody
	public User getUserById(Integer id) {
		return userService.getUserById(id);
		
	}
	//登出
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		//销毁session
		request.getSession().invalidate();
		//重定向到登录页面  /user/toLogin在配置文件配置了,如果写此地址就是去login.html页面
		return "redirect:/user/toLogin";
	}
	//登录
	@PostMapping("/login")
	public String login(@RequestParam String name,@RequestParam String password,@RequestParam String code,
			HttpServletRequest request) throws ET1911LoginException {
		//session中的验证码和请求参数的验证码进行比对
		HttpSession session = request.getSession();
		//拿取session中的验证码的值
		String sessionCode = (String)session.getAttribute("code");
		//如果拿取的session中的值和前端传过来的不一致就会报错  抛出自己写的异常
		if(!code.equals(sessionCode)) {
			throw new ET1911LoginException("验证码不正确~~~");
			
		}
		//将前端输入的密码etoak改成密文 和数据库的一致
		password =DigestUtils.md5Hex(password);
		//根据用户名和密码查询那一个实体类对象
		User user = userService.getByNameAndPass(name, password);
		//如果user为空
		if(ObjectUtils.isEmpty(user)) {
			//进行抛异常
			throw new ET1911LoginException("用户名或者密码不正确~~~");
		}
		System.out.println(session.getAttribute("code") +"===session==="+ session.getAttribute("user"));
		//13===session===null
		//销毁之前的session
		session.invalidate();
		//将密码设置为空
		user.setPassword(null);
		session=request.getSession();
		session.setAttribute("user",user);
		System.out.println("session===>"+session.getAttribute("user")+"------"+session.getAttribute("code"));
		//  session===>User(id=1, name=张三, password=null, age=25)
		
		//重定向到index.html页面
		return "redirect:/";
	}
}
