package com.microservice.oauthlogin.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservice.oauthlogin.dto.ResponseDTO;

import feign.Headers;

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
		@Headers("Content-Type : application/json")
		ResponseDTO returnUserRolesAndPermission(@RequestHeader("Authorization")String authHeader);
	}

	
	 public  ResponseDTO returnUserRolesAndPermission(String authHeader) {
	        return theClient.returnUserRolesAndPermission(authHeader);
	    }

}
///@RequestHeader("X-Auth-Token") String authHeader,
//String authHeader