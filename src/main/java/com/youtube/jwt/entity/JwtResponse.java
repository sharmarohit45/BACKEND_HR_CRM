package com.youtube.jwt.entity;

public class JwtResponse {
    private Object user;
    private String jwtToken;

    public JwtResponse(Object user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

    
}
