package com.etoak.mapper;

import com.etoak.bean.User;

public interface UserMapper {

	//根据id查询用户
	User getUerById(Integer id);
}
