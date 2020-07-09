package com.microservices.oauthlogin.dto;

import java.util.List;

public class UserRoleDto {

	private String userRole;

	private List<String> userRolepermission;

	public UserRoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRoleDto(String userRole, List<String> userRolepermission) {
		super();
		this.userRole = userRole;
		this.userRolepermission = userRolepermission;
	}

}
