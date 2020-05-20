package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.Student;

@Controller
@RequestMapping("complex")
public class ComplexController {

	@GetMapping("/bean")
	public String bean(Student stu,Model model) {
		System.out.println(stu);
		model.addAttribute("result2", "使用Model传值");
		return "forward:/simple/simple?id=100";
	}
	
	@PostMapping("/array")
	public String array(String[] hobby,ModelMap modelMap) {
		for(String s :hobby) {
			System.out.println("hobby==>"+s);
		}
		modelMap.addAttribute("result","使用modelMap传参");
		return "param";
		
	}
	
	@PostMapping("/list")
	public String list(Student stu,Map<String, Object> map) {
		List<String> hobbyList =stu.getHobbyList();
		if(!CollectionUtils.isEmpty(hobbyList)) {
			hobbyList.forEach(x -> System.out.println(x));
		}
		map.put("result", "使用Map传值");
		return "param";	
	}
	
	@RequestMapping(value="/map",produces = {"text/plain"})
	@ResponseBody
	public String map(Student stu) {
		System.out.println(stu.getStuMap());
		return "success";
	}
	
}
