package com.springweb.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springweb.entity.User;

@Controller
public class Admin {
	
	
	User user;
	
	@RequestMapping(value = "/admin")
	public String welcome(Model model) {
		return "admin/admin";
	}
}
