package top.microiot.domain;

import java.io.Serializable;

public class Token implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1980273414299017457L;
	private String token;
	private String refreshToken;

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Token(String token, String refreshToken) {
		super();
		this.token = token;
		this.refreshToken = refreshToken;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
}
