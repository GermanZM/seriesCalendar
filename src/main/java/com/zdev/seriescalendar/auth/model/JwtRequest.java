package com.zdev.seriescalendar.auth.model;

public class JwtRequest {
	
	private String username;
	private String password;
	
	public JwtRequest() {}
	
	public JwtRequest(String pUsername, String pPassword) {
		this.username = pUsername;
		this.password = pPassword;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
