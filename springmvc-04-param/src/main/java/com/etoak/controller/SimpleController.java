package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.regexp.internal.recompile;

@Controller
@RequestMapping("/simple")
public class SimpleController {

	@RequestMapping("/servlet")
	public String servlet(HttpServletRequest request) {
		//1.接收参数
		String name =request.getParameter("name");
		if(StringUtils.isEmpty(name)) {
			name = "空了";
		}
		request.setAttribute("result", "Hello "+name);
		return "param";
	}
	@RequestMapping(value="/simple",method= {RequestMethod.GET})
	public ModelAndView simple(@RequestParam(required = false,defaultValue = "666") int id,@RequestParam(required = false,defaultValue = "lxy") String name) {
		
		System.err.println("id param==>"+id);
		System.err.println("name param==>"+name);
		ModelAndView mv =new ModelAndView();
		mv.addObject("result","ModelAndView 传值==>name="+name+" id="+id);
		mv.setViewName("param");
		return mv;
	}
	
	
	
}
