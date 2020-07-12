package com.microservice.oauthlogin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.microservice.oauthlogin.entity.UserRole;
import com.microservice.oauthlogin.entity.UserRolePermission;


public class UserRoleDto {
	
	private static final long serialVersionUID = 4125965356358329466L;
	
	
	private UserRole userRole;

	@JsonInclude
	private List<UserRolePermission> userRolepermission;

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<UserRolePermission> getUserRolepermission() {
		return userRolepermission;
	}

	public void setUserRolepermission(List<UserRolePermission> userRolepermission) {
		this.userRolepermission = userRolepermission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserRoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRoleDto(UserRole userRole, List<UserRolePermission> userRolepermission) {
		super();
		this.userRole = userRole;
		this.userRolepermission = userRolepermission;
	}

}
