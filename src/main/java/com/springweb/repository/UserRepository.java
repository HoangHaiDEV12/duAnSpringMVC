package com.springweb.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springweb.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findUserByUserName(String userName);

	User findUserByEmail(String email);
	
	@Query(
			  value = "update user set password = ?1 where email = ?2", 
			  nativeQuery = true)
	User changePassByEmail(String newPass, String email);

}
