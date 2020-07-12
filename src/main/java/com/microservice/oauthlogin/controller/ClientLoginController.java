package com.microservice.oauthlogin.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.oauthlogin.dto.ResponseDTO;
import com.microservice.oauthlogin.entity.AccessTokenEntity;
import com.microservice.oauthlogin.restclient.LoginRestClient;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


@RestController
@EnableDiscoveryClient
public class ClientLoginController {

	private static final Logger log = LoggerFactory.getLogger(ClientLoginController.class);

	@Autowired
	private LoginRestClient serviceConsumer;

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_FINANCE = "ROLE_FINANCE";
    
    
	@GetMapping(value = "/signin")
	@Secured({ROLE_ADMIN,ROLE_FINANCE})
	public  ResponseDTO login() throws IOException {
		
		String username=SecurityContextHolder.getContext().getAuthentication()
                .getName();
		String credentials= (String)SecurityContextHolder.getContext().getAuthentication().getCredentials();
		
		
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
				RequestBody body = RequestBody.create(mediaType, "username="+username+"&password="+credentials+"&grant_type=password&scope=trust");
				Request request = new Request.Builder()
				  .url("http://localhost:9080/oauth/token")
				  .method("POST", body)
				  .addHeader("Authorization", "Basic c2FtYnVkZGhhOmRldmdsYW4tc2VjcmV0")
				  .addHeader("Content-Type", "application/x-www-form-urlencoded")
				  .build();
				okhttp3.ResponseBody response = client.newCall(request).execute().body();
				ObjectMapper mapper = new ObjectMapper();
				AccessTokenEntity entity = mapper.readValue(response.string(), AccessTokenEntity.class);
				 


				
				
		System.out.println("Access Token Response ---------" + entity.getAccess_token());

		// Get the Access Token From the recieved JSON response
	
		//String token = node.path("access_token").asText();

		String authHeader = "Bearer " + entity.getAccess_token();
		System.out.println(authHeader);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
		System.out.println("Print the token Details :- "+ authentication.getDetails().toString());
		return serviceConsumer.returnUserRolesAndPermission(authHeader);
	}

}
