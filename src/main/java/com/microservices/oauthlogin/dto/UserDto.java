package com.microservices.oauthlogin.dto;

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
