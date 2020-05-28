package com.etoak.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.etoak.bean.User;

public class LoginIntercaptor implements HandlerInterceptor {//拦截器
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object object) throws IOException {
		//先获取session
		HttpSession session =request.getSession();
		User user =(User)session.getAttribute("user");
		//如果用户为空 则登录到登录页面
		if(ObjectUtils.isEmpty(user)) {
			String path =request.getContextPath();
			response.sendRedirect(path+"/user/toLogin");
			return false;
		}
		return true;
	}
}
