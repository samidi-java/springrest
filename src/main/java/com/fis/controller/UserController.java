package com.fis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.model.UserInfo;
import com.fis.service.UserDetailsServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UserDetailsServiceImpl service;
	
	@PostMapping("/user/create")
	public UserInfo createUser(@RequestBody UserInfo user)
	{
		return service.createUser(user);
	}

}
