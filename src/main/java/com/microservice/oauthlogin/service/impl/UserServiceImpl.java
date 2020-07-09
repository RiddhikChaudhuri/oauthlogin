package com.microservice.oauthlogin.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.oauthlogin.entity.User;
import com.microservice.oauthlogin.entity.UserRole;
import com.microservice.oauthlogin.repository.UserRepository;
import com.microservice.oauthlogin.service.UserService;
import com.microservices.oauthlogin.dto.ResponseDTO;
import com.microservices.oauthlogin.dto.UserRoleDto;

@Service("userService")
public class UserServiceImpl implements UserDetailsService, UserService{
	
	@Autowired
	UserRepository userRepository;

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByUserName(username);
		
		Set grantedAuthorities = getAuthorities(user);
		
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword().toString(), grantedAuthorities);
        
	}
	
	private Set getAuthorities(User user) {
        Set<UserRole> roleByUserId = user.getRoles();
        final Set authorities = roleByUserId.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toString().toUpperCase())).collect(Collectors.toSet());
        return authorities;
    }

	
	public ResponseDTO loadUserRoleDetailsByUserName(String username) {
		User user = userRepository.getUserByUserName(username);
		
		Set grantedAuthorities = getAuthorities(user);
		
		
		return null;
	}
	

}
