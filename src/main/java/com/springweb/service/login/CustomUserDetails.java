package com.springweb.service.login;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springweb.entity.User;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	User user;

	private Set<GrantedAuthority> customAuthorities;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<GrantedAuthority> getCustomAuthorities() {
		return customAuthorities;
	}

	public void setCustomAuthorities(Set<GrantedAuthority> customAuthorities) {
		this.customAuthorities = customAuthorities;
	}

	public CustomUserDetails(User user, Set<GrantedAuthority> authorities) {
		this.user = user;
		this.customAuthorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return customAuthorities;
	}

	@Override
	public String getPassword() {
		return user.getPassWord();
	}

	
	public String getfullName() {
		return user.getFullName();
	}
	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
