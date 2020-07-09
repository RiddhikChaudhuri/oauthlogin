package com.microservices.oauthlogin.dto;

public class LoginDto {

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	private String username;
	
	private char[] password;
}
