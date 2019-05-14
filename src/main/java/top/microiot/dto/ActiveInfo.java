package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class ActiveInfo {
	@NotEmpty(message="token can't be empty")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
