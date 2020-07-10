package com.microservice.oauthlogin.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service(value = "userService")
public interface UserService {
	
	public List loadUserRoleDetailsByUserName(String username);

}
