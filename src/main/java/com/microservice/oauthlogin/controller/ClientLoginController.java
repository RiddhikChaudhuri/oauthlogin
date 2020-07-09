package com.microservice.oauthlogin.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.oauthlogin.repository.UserRepository;
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
	//@Secured({"ROLE_ADMIN","ROLE_FINANCE"})
    public String login() {
        
        return serviceConsumer.returnUserRolesAndPermission();
    }

	
	
//	 @PostMapping("/registration")
//	  @ResponseStatus(code = HttpStatus.CREATED)
//	  public void register(@RequestBody LoginDto userCredentialsDto) {
//		 System.out.println(userCredentialsDto.getPassword());
//	    User user = new User(
//	      userCredentialsDto.getUsername(),
//	      passwordEncoder.encode(String.valueOf(userCredentialsDto.getPassword())));
//	    System.out.println(passwordEncoder.encode(String.valueOf(userCredentialsDto.getPassword())));
//	    String password = passwordEncoder.encode(String.valueOf(userCredentialsDto.getPassword()));
//	    log.debug(String.valueOf(user.getPassword()));
//	    userRepository.save(user);
//	    System.out.println(userRepository.getUserByUserName("username").getPassword().toString());
//	  }
}
