package com.infy.demo.service;

import java.util.List;

import com.infy.demo.entity.User;

public interface LoginService {
	
	public List checkLogin(User user) throws Exception;

}
