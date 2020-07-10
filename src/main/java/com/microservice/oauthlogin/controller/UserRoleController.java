package com.microservice.oauthlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.oauthlogin.service.UserService;


@EnableDiscoveryClient
@RestController
public class UserRoleController {

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_FINANCE = "ROLE_FINANCE";
    
    @Autowired
	private UserService userService;
	
    
	@PostMapping("/userRoles")
	//@Secured({ROLE_ADMIN,ROLE_FINANCE})
	public List returnUserRolesAndPermission(String username) {
        return userService.loadUserRoleDetailsByUserName(username);
    }
}
