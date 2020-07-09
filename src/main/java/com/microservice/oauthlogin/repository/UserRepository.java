package com.microservice.oauthlogin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.microservice.oauthlogin.entity.User;
 
/* Need to change this to JPARepository */
public interface UserRepository extends CrudRepository<User,Long>{
	
	@Query("SELECT u FROM User u WHERE u.userName = :username")
    public User getUserByUserName(@Param("username") String username);
	
	
	

}
