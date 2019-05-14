package top.microiot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class OrgInfo {
	@NotEmpty(message="organization name can't be empty")
	private String orgName;
	private String address;
	@Email(message="email format error")
	private String email;
	@NotEmpty(message="password  can't be empty")
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
