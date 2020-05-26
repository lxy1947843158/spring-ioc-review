package com.etoak.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;

public interface CarMapper {
	//添加车辆信息
	int addCar(Car car);
	//查询车辆信息(最终版)
	List<CarVo> queryAllCar(CarVo carVo);
	//查询所有的品牌
	List<String> getAllBrand();
	//根据品牌名字查车系名字,当品牌为空的时候,随机查询10个车系
	List<String> querySeriesByBrand(@Param("brand") String brand);
	//根据车系名字查询价格
	List<String> queryPriceBySerices(@Param("series") String series);
}
