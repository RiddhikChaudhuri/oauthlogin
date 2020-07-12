package com.microservice.oauthlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class OauthloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthloginApplication.class, args);
	}
	
	
	
	
	

}
