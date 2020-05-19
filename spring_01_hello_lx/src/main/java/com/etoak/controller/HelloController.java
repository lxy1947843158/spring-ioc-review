package com.etoak.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HelloController implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//接收参数
		String name =request.getParameter("name");
		
		System.out.println("参数值===>"+name);
		
		//把参数放到request域值里面
		request.setAttribute("jieguo",name );
		
		//必须用请求转发 将值发往页面
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
		

	}

}
