package com.etoak.mapper;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.User;

public interface UserMapper {

	//根据id查询用户
	User getUerById(Integer id);
	User getByNameAndPass(@Param("name") String name,@Param("password") String password);
}
