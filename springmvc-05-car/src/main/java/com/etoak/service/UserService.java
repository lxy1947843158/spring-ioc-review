package com.etoak.service;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.User;

public interface UserService {
	User getUserById(Integer id);
	
	User getByNameAndPass( String name, String password);
}
