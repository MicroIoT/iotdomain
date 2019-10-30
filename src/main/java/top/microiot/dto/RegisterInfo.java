package top.microiot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class RegisterInfo {
	@Email(message="email format error")
	private String email;
	@NotEmpty(message="password can't be empty")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
