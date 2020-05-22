package com.etoak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;

@Controller
public class IndexController {
	@RequestMapping("/add")
	public String add(String name) {
		System.out.println(name);
		return "forward:/index";
	}
	@RequestMapping("/json")
	@ResponseBody
	public String json(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		return "success";
	}
	
	

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		request.setAttribute("user", new User(1,"requestUser","",25));
		
		//向session中传值
		request.getSession().setAttribute("sessionUser", new User(2,"sessionUser","",25));
		
		//用于测试thymeleaf遍历List
		List<User> list =new ArrayList<User>();
		request.setAttribute("userList", list);
		list.add(new User(3,"张三","",25));
		list.add(new User(4,"李四","",25));
		
		//返回到index.html
		return "index";
	}
}
