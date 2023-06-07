package com.springweb.service.Impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.entity.Role;
import com.springweb.entity.User;
import com.springweb.entity.UserRole;
import com.springweb.repository.RoleRepository;
import com.springweb.repository.UserRepository;
import com.springweb.repository.UserRoleRepository;
import com.springweb.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void saveUser(User user) throws SQLException {

		userRepository.save(user);
	}


	@Override
	public void saveUserRole(UserRole userRole) throws SQLException {
		userRoleRepository.save(userRole);
	}
	@Override
	public User findUserByEmail(String email) {
	
		return userRepository.findUserByEmail(email);
	}


	@Override
	public Role findRoleByRoleName(String roleName) {
		
		return roleRepository.findRoleByRoleName(roleName); 
	}


	@Override
	public User changePassByEmail(String newPass, String email) {
		return null;
	}


	

	

}
