package com.microservice.oauthlogin;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OAuthResourceServerConfiguration extends ResourceServerConfigurerAdapter{

	
	private static final String RESOURCE_ID = "resource_id";

	 @Override
	   public void configure(ResourceServerSecurityConfigurer resources) {
	       resources.resourceId(RESOURCE_ID);
	   }
	

	 
	 
	 @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().anonymous().disable()
	        		
	                .antMatcher("/api/**")
	                .authorizeRequests()
	                .antMatchers("/registration/**").permitAll()
	                .antMatchers("/h2-console**").permitAll()
	                .antMatchers("/userRoles**").hasAnyAuthority("ADMIN","FINANCE");
	                
	                
	    }

}