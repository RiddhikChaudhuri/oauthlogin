package com.microservices.oauthlogin.dto;

import java.util.List;

public class ResponseDTO {
	
	private List<UserRoleDto> userRoleDto;

	public List<UserRoleDto> getUserRoleDto() {
		return userRoleDto;
	}

	public void setUserRoleDto(List<UserRoleDto> userRoleDto) {
		this.userRoleDto = userRoleDto;
	}
	
	

}
