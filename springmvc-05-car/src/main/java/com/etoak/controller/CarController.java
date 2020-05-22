package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
@Autowired
CarService carService;
	
	//跳转到车辆添加页面
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}
	
	@RequestMapping("/add")
	public String add(MultipartFile file,Car car) throws IllegalStateException, IOException {
		log.info("文件名称 - {}",file.getOriginalFilename());
		log.info("param car - {}",car);
		// 
		//新文件名称
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		String NewFileName=uuid+"_"+file.getOriginalFilename();
		
		File destFile = new File("E:\\LG\\upload",NewFileName);
		//执行文件上传
		file.transferTo(destFile);
		//设置图片地址
		car.setPic("/pic/"+NewFileName);
		//调用Service执行添加
		carService.addCar(car);
		//重定向的方式返回页面
		return "redirect:/car/toAdd";
	}
}
