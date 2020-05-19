package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
