package com.etoak.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.etoak.bean.Student;
import com.etoak.bean.User;
import com.etoak.result.ResultVo;

@RestController
@RequestMapping("/json")
public class JsonController {
	
	@PostMapping(value="/jsonTomap",produces = "application/json;charset=UTF-8")
	public Object JsonToMap(@RequestBody Map<String, Object> jsonMap) {
		System.out.println(jsonMap);
		//String ==> json
		return "{\"msg\":\"success\"}";	
	}
	
	@PostMapping("/jsonTolist")
	public Map<String, Object> jsonTolist(@RequestBody List<User> userList){
		userList.forEach(x -> System.out.println(x));
		
		Map<String, Object> resultMap =new HashMap<String, Object>();
		resultMap.put("code", 200);
		resultMap.put("msg", "success");
		return resultMap;
	}
	
	@PostMapping("/jsonTobean")
	public ResultVo jsonTobean(@RequestBody Student stu) {
		System.out.println(stu);
		return new ResultVo(200,"success");
	}

}
