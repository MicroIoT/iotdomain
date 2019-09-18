package top.microiot.domain;

import java.io.Serializable;

public class Token implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1980273414299017457L;
	private String token;

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Token(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
