package com.microservice.oauthlogin.controller;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.oauthlogin.restclient.LoginRestClient;
import com.microservice.oauthlogin.service.UserService;

@RestController
@EnableDiscoveryClient
public class ClientLoginController {

	private static final Logger log = LoggerFactory.getLogger(ClientLoginController.class);

	public static final String SUCCESS = "success";

	@Autowired
	private UserService userService;
	
	 
	 @Autowired
	 private LoginRestClient serviceConsumer;
	
	


	@GetMapping(value = "/signin")
	@Secured({"ROLE_FINANCE","ROLE_ADMIN"})
    public String login(HttpServletRequest request) {
		  request.getUserPrincipal().getName();
        
        return serviceConsumer.returnUserRolesAndPermission(request.getUserPrincipal().getName());
    }


}
