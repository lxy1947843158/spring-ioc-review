package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//CarVo里面装的是查询条件
public class CarVo extends Car{//去继承Car 可以拥有Car里面的所有属性以及自己的属性
	private String levelName;
	private String bsboxName;
	private String outputName;
	@JsonIgnore //返回的结果不会封装进去
	private List<Map<String,Integer>> priceMapList;
	@JsonIgnore
	private String carage;
	@JsonIgnore
	private Integer startYear;
	@JsonIgnore
	private Integer endYear;
	
	
}
