package com.springweb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springweb.service.login.CustomUserDetails;

@Controller
public class HomePageController {

	@RequestMapping(value = "/homepage")
	public String welcome(Model model) {

		SecurityContext context = SecurityContextHolder.getContext();

		Authentication authentication = context.getAuthentication();

		if (authentication.getPrincipal() instanceof UserDetails) {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			model.addAttribute("user", userDetails.getUser());
			model.addAttribute("name", userDetails.getUser());
		}

		return "homepage";
	}

}
