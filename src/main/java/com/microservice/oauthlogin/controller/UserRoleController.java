package com.microservice.oauthlogin.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableDiscoveryClient
@RestController
public class UserRoleController {

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_FINANCE = "ROLE_FINANCE";
    
    
    
	@GetMapping("/userRoles")
	//@Secured({ROLE_ADMIN,ROLE_FINANCE})
	public String returnUserRolesAndPermission() {
        return "hello";
    }
}
