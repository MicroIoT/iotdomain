package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

/**
 * 修改密码输入信息类。
 *
 * @author 曹新宇
 */
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
