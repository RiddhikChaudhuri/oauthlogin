package com.microservice.oauthlogin.service;

import org.springframework.stereotype.Service;

import com.microservice.oauthlogin.dto.ResponseDTO;

@Service(value = "userService")
public interface UserService {
	
	public ResponseDTO loadUserRoleDetailsByUserName(String username);

}
