package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录系统输入信息类。
 *
 * @author 曹新宇
 */
public class LoginInfo {
	@NotEmpty(message="username can't be empty")
	private String username;
	@NotEmpty(message="password can't be empty")
	private String password;
	private String domain;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
}
