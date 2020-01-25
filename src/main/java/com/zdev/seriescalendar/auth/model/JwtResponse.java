package com.zdev.seriescalendar.auth.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 5418206799591143042L;
	
	private final String jwtToken;
	
	public JwtResponse(String pJwtToken) {
		this.jwtToken = pJwtToken;
	}
	
	public String getJwtToken() {
		return jwtToken;
	}
	
}
