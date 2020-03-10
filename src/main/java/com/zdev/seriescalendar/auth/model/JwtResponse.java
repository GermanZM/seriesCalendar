package com.zdev.seriescalendar.auth.model;

public class JwtResponse {
	
	private final String jwtToken;
	
	public JwtResponse(String pJwtToken) {
		this.jwtToken = pJwtToken;
	}
	
	public String getJwtToken() {
		return jwtToken;
	}
	
}
