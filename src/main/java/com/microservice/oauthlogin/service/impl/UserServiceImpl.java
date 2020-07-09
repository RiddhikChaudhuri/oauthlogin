package com.microservice.oauthlogin.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.oauthlogin.entity.User;
import com.microservice.oauthlogin.repository.UserRepository;
import com.microservice.oauthlogin.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserDetailsService, UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByUserName(username);
		
		//GrantedAuthority authority = new SimpleGrantedAuthority(user.getRoles().toString());
		GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword().toString(), Arrays.asList(authority));
        
        //return new org.springframework.security.core.userdetails.User("username", "password",Arrays.asList(authority));
    }
	
	
	

}
