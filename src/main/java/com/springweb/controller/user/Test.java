package com.springweb.controller.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.springweb.service.UserService;

@Controller
public class Test {
	
	@Autowired
	UserService UserService;

//	@RequestMapping(value = "/user")
//	public String welcome(@ModelAttribute("uRequest") SaveUserRequest uRequest) {
//		
//		User user = new User();
//		
//		user.setUserName(uRequest.getUsername());
//		user.setFullName(uRequest.getFullname());
//		user.setEmail(uRequest.getMail());
//		user.setPassWord(uRequest.getPassword());
//		
//		UserService.saveUser(user);
//		
//		return "user/user";
	}

