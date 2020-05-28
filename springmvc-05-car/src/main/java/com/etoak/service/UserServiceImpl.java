package com.etoak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getUserById(Integer id) {
		return userMapper.getUerById(id);
	}

	@Override
	public User getByNameAndPass(String name, String password) {
		return userMapper.getByNameAndPass(name, password);
	}

}
