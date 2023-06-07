package com.springweb.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springweb.entity.User;

@Controller
public class TestAdmin {
	
	
	User user;
	
	@RequestMapping(value = "/admin")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String welcome(Model model) {
System.out.println("hahahaaaa");
		return "admin/admin";
	}
}
