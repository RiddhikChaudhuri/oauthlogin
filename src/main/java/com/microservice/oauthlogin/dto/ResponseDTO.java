package com.microservice.oauthlogin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
public class ResponseDTO {
	
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 5L;

	
	public ResponseDTO(List<UserRoleDto> userRoleDto) {
		super();
		this.userRoleDto = userRoleDto;
	}

	@JsonInclude
	@JsonProperty(value = "UserRolesandPermission")
	private List<UserRoleDto> userRoleDto;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<UserRoleDto> getUserRoleDto() {
		return userRoleDto;
	}

	public void setUserRoleDto(List<UserRoleDto> userRoleDto) {
		this.userRoleDto = userRoleDto;
	}
	
	

}
