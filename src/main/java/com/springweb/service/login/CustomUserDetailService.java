package com.springweb.service.login;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springweb.entity.Role;
import com.springweb.entity.User;
import com.springweb.entity.UserRole;
import com.springweb.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = userRepository.findUserByUserName(userName);
		
	

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (UserRole userRole : user.getRloes()) {
		Role role = userRole.getRole();
		authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		
		}
		return new CustomUserDetails(user, authorities);
	}

}
