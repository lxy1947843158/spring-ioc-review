package com.etoak.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.ArrayUtils;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.mapper.CarMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarServiceImpl implements CarService {
@Autowired
CarMapper carMapper;
	
	@Override
	public int addCar(Car car) {
		
		return carMapper.addCar(car);
	}

	
	@Override
	public PageVo<CarVo> queryList(int pageNumber, int pageSize, CarVo carVo,String[] priceList) {
		//处理价格区间
		List<Map<String,Integer>> priceMapList =this.handlePrice( priceList);
		carVo.setPriceMapList(priceMapList);
		//处理车龄
		this.handleCarAge(carVo);
		//设置分页条件
		PageHelper.startPage(pageNumber, pageSize);
		//查询列表
		List<CarVo> carList = carMapper.queryAllCar(carVo);
		PageInfo<CarVo> pageInfo =new PageInfo<CarVo>(carList);
		return new PageVo<CarVo>(pageInfo.getPageNum(),
				pageInfo.getPageSize(),
				carList,
				pageInfo.getTotal(),
				pageInfo.getPages(),
				pageInfo.isIsFirstPage(),
				pageInfo.isIsLastPage()
				);
		
	}


	



	private void handleCarAge(CarVo carVo) {
		//前端传来的值: 0-1/1-3/3-5
		String carage = carVo.getCarage();
		if(!StringUtils.isEmpty(carage)) {
			String[] carageArray = carage.split("-");
			for(String s :carageArray) {
				System.out.println("接到的时间==>"+s);
				//3 5
			}
			
			if(!"0".equals(carageArray[0])) {
				carVo.setEndYear(Integer.parseInt(carageArray[0]));
			}
			if(!"0".equals(carageArray[1])) {
				carVo.setStartYear(Integer.parseInt(carageArray[1]));
			}
			
		}
		
	}


	private List<Map<String, Integer>> handlePrice(String[] priceList) {
		List<Map<String, Integer>> priceMapList =new ArrayList<Map<String,Integer>>();
		if(! ArrayUtils.isEmpty(priceList)) {
			for(String priceStr: priceList) {
				System.out.println("参数priceList===>"+priceStr);//参数priceList===>3-5
				String[] prices =priceStr.split("-");
				System.out.println("劈开后的参数==>"+prices[0]+"====>"+prices[1]);//劈开后的参数==>3====>5
				Map<String, Integer> priceMap =new HashMap<String, Integer>();
				priceMap.put("start", Integer.parseInt(prices[0]));
				priceMap.put("end", Integer.parseInt(prices[1]));
				priceMapList.add(priceMap);
			}
		}
		for(Map<String, Integer> m : priceMapList) {
			System.out.println("priceMapList==>"+m);//priceMapList==>{start=3, end=5}
		}
		return priceMapList;
	}


	@Override
	public List<String> querySeriesByBrand(String brand) {
	return carMapper.querySeriesByBrand(brand);
	}


	@Override
	public List<String> getAllBrand() {
		return carMapper.getAllBrand();
	}


	@Override
	public List<String> queryPriceBySerices(String series) {
		return carMapper.queryPriceBySerices(series);
	}




	

}
