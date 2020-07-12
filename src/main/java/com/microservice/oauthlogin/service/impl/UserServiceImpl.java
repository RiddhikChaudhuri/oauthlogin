package com.microservice.oauthlogin.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.oauthlogin.dto.ResponseDTO;
import com.microservice.oauthlogin.dto.UserRoleDto;
import com.microservice.oauthlogin.entity.User;
import com.microservice.oauthlogin.entity.UserRole;
import com.microservice.oauthlogin.repository.UserRepository;
import com.microservice.oauthlogin.repository.UserRolePermissionRepository;
import com.microservice.oauthlogin.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserDetailsService, UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRolePermissionRepository userRolePermissionRepository;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByUserName(username);
		
		@SuppressWarnings("rawtypes")
		Set grantedAuthorities = getAuthorities(user);
		
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword().toString(), grantedAuthorities);
        
	}
	
	private Set getAuthorities(User user) {
        Set<UserRole> roleByUserId = user.getRoles();
        final Set authorities = roleByUserId.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toString().toUpperCase())).collect(Collectors.toSet());
        return authorities;
    }

	
	public ResponseDTO loadUserRoleDetailsByUserName(String username) {
		User user = userRepository.getUserByUserName("riddhik");
		
		Set<UserRole> roleByUserId = user.getRoles();
		
		Iterator<UserRole> it = roleByUserId.iterator();
		List<UserRoleDto> userRoleDTOList= new ArrayList<UserRoleDto>();
		while(it.hasNext()){
			
			UserRole ROLE= it.next();
			UserRoleDto userRoleDTO  = new UserRoleDto(ROLE,userRolePermissionRepository.findUserRolePermissionByuserRole(ROLE));
			userRoleDTOList.add(userRoleDTO);
	       
	     }
		
		ResponseDTO responseDTOObject = new ResponseDTO(userRoleDTOList);
		
		return responseDTOObject;
	}
	

}
