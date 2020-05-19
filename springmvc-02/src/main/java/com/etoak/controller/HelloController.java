package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取前端的参数
		String name = request.getParameter("name");
		//调用service 暂不处理.....
		
		//返回页面
		ModelAndView mv =new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("result", "Hello!!!"+ name);
		return mv;
	}

}
