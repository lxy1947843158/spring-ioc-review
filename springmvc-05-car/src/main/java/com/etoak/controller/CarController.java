package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.exception.ParamException;
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
	
	@RequestMapping("/toList")
	public String list() {
		return "car/list";
	}
	
	@RequestMapping("/add")
	public String add(MultipartFile file,@Valid Car car,BindingResult bindingResult,HttpServletRequest request) throws IllegalStateException, IOException {
		
		// 先校验参数
		List<ObjectError> errors=bindingResult.getAllErrors();
		//如果校验结果集不为空,则取出错误校验信息
		if(!CollectionUtils.isEmpty(errors)) {
			StringBuffer errorBuff = new StringBuffer();
			for(ObjectError e : errors) {
				
				String errorMsg = e.getDefaultMessage();
				errorBuff.append(errorMsg).append(";");
			}
			//request.setAttribute("paramError",errorBuff.toString());
			//return "forward:/car/toAdd";
			throw new ParamException(errorBuff.toString());
		}
		log.info("文件名称 - {}",file.getOriginalFilename());
		log.info("param car - {}",car);
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
	
	@RequestMapping("/list")
	@ResponseBody
	public PageVo<CarVo> queryAllCar(@RequestParam(required = false,defaultValue = "1") int pageNum
			,@RequestParam(required = false,defaultValue = "8") int pageSize
			,CarVo carVo,String[] priceList) {
		return carService.queryList(pageNum, pageSize, carVo,priceList);
	}
	@RequestMapping("/brand")
	@ResponseBody
	public List<String> getBrand(){
		return carService.getAllBrand();
	}
	
	@RequestMapping("/series")
	@ResponseBody
	public List<String> querySeriesByBrand(@RequestParam String brand){
		log.info("param brand - {}",brand);
		return carService.querySeriesByBrand(brand);
	}
	
	@RequestMapping("/listseries")
	@ResponseBody
	public List<String> querySeriesByBrand(){
		return carService.querySeriesByBrand(null);
	}
	
	@RequestMapping("/price")
	@ResponseBody
	public List<String> queryPriceBySerices(@RequestParam String series){
		return carService.queryPriceBySerices(series);
	}
	
}
