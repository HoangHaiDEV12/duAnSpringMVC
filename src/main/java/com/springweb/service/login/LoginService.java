package com.springweb.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	 private final AuthenticationManager authManager;
	  
	  /**
	   * Constructor.
	   */
	  @Autowired
	  public LoginService( AuthenticationManager authManager) {
	    this.authManager = authManager;
	  }
	  
	  public Authentication login(String userName, String passWord) {
	    Authentication authentication;

	    Authentication request = new UsernamePasswordAuthenticationToken(userName,
	    		passWord);

	    authentication = authManager.authenticate(request);
	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    return authentication;
	  }
}
