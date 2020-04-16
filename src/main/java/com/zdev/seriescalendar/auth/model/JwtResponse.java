package com.zdev.seriescalendar.auth.model;

public class JwtResponse {
	
	private final CustomUser user;
	private final String jwtToken;
	
	public JwtResponse(String pJwtToken, CustomUser user) {
		this.user = user;
		this.jwtToken = pJwtToken;
	}
	
	public String getJwtToken() {
		return this.jwtToken;
	}
	
	public CustomUser getCustomUser() {
		return this.user;
	}
	
}
