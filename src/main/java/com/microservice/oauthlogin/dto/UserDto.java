package com.microservice.oauthlogin.dto;

@com.fasterxml.jackson.annotation.JsonAutoDetect
public class UserDto {
	
	private String userName;
	
	private String userRole;
	
	private String userRolePermission;

	public UserDto(String userName, String userRole, String userRolePermission) {
		super();
		this.userName = userName;
		this.userRole = userRole;
		this.userRolePermission = userRolePermission;
	}
	
	

}
