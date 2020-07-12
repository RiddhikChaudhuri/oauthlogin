package com.microservice.oauthlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.oauthlogin.dto.ResponseDTO;
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
	
	public  ResponseDTO returnUserRolesAndPermission(@RequestHeader HttpHeaders httpsHeaders) {
		//System.out.println("Print from Feign Client :-"+request.getUserPrincipal().getName());
		httpsHeaders.entrySet().stream().forEach(System.out::println);
		//System.out.println("AuthHeader:-"+authHeader);
		
		ResponseDTO responseDTOObject = userService.loadUserRoleDetailsByUserName(SecurityContextHolder.getContext().getAuthentication()
                .getName());
        return responseDTOObject;
    }
}
