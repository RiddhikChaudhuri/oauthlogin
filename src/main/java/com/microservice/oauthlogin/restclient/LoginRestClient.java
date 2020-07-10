package com.microservice.oauthlogin.restclient;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class LoginRestClient {

	
	@Autowired
	private TheClient theClient;
	
	
	
	
	
	/**
	 * Create a REST-ful client to connect to the user Roles rest service on the Zoo Keeper
	 *
	 */
	@FeignClient("UserRolesConsumer")
	interface TheClient {
		@RequestMapping(path = "/userRoles", method = RequestMethod.POST)
		@ResponseBody
		String returnUserRolesAndPermission(String userName);
	}

	
	 public String returnUserRolesAndPermission(String userName) {
	        return theClient.returnUserRolesAndPermission(userName);
	    }

}
