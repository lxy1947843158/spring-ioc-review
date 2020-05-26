package com.etoak.service;

import java.util.HashMap;
import java.util.List;
import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;

public interface CarService {

	//添加车辆
	int addCar(Car car);
	//根据品牌名字查询车系
	List<String> querySeriesByBrand(String brand);
	//查询所有的品牌
	List<String> getAllBrand();
	//根据车系名字查询价格
	List<String> queryPriceBySerices(String series);
	//查询车辆信息(修改版)
	PageVo<CarVo> queryList(int pageNumber,int pageSize,CarVo carVo, String[] priceList);
}
