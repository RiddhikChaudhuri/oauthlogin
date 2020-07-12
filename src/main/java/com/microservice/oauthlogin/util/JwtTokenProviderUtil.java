package com.microservice.oauthlogin.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProviderUtil {

	@Value("${security.jwt.token.secret-key}")
	  private String secretKey;

	  @Value("${security.jwt.token.expire-length:3600000}")
	  private long validityInMilliseconds = 3600000; // 1h

	 
	 
	  
	  
	  
}
