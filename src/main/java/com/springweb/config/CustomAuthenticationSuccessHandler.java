	package com.springweb.config;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			if (authority.toString().equals("ROLE_USER")) {
				response.sendRedirect("/com.springweb/homepage?name=" + authentication.getName());
				return;
				} 
			
			else if (authority.toString().equals("ROLE_ADMIN")) {
				
				response.sendRedirect("/com.springweb/loginoption?name=" + authentication.getName());
				return;
				
			}
				
		
		}
	}

}
