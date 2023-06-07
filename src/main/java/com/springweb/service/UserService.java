package com.springweb.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.springweb.entity.Role;
import com.springweb.entity.User;
import com.springweb.entity.UserRole;

@Service
public interface UserService {

	void saveUser(User user) throws SQLException;
	
	
	void saveUserRole(UserRole userRole) throws SQLException;


	User findUserByEmail(String email);

	Role findRoleByRoleName( String roleName);
	

	User changePassByEmail(String newPass, String email);
}
