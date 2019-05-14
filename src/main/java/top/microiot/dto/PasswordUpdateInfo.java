package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class PasswordUpdateInfo {
	@NotEmpty(message="password can't be empty")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
