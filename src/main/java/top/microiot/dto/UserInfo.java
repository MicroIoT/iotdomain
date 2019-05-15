package top.microiot.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import top.microiot.domain.Role;

/**
 * 系统用户输入信息类。
 *
 * @author 曹新宇
 */
public class UserInfo {
	@NotEmpty(message="username can't be empty")
	private String username;
	@NotEmpty(message="password can't be empty")
	private String password;
	@Email(message="email format error")
	private String email;
	private Role role;
	private List<String> area;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getArea() {
		return area;
	}
	public void setArea(List<String> area) {
		this.area = area;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
