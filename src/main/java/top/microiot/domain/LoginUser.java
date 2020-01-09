package top.microiot.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class LoginUser {
	@Id
    private String id;
	@Indexed(unique=true)
	private String token;
	@Indexed(unique=true)
	private String refreshToken;
	private String ip;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date expire;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date refreshExpire;
	private String username;
	private boolean isDevice;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date loginTime;
	
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginUser(String token, String refreshToken, String username, boolean isDevice, String ip, Date expire, Date refreshExpire) {
		super();
		this.token = token;
		this.refreshToken = refreshToken;
		this.username = username;
		this.isDevice = isDevice;
		this.ip = ip;
		this.expire = expire;
		this.refreshExpire = refreshExpire;
		this.loginTime = new Date();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isDevice() {
		return isDevice;
	}

	public void setDevice(boolean isDevice) {
		this.isDevice = isDevice;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public Date getRefreshExpire() {
		return refreshExpire;
	}

	public void setRefreshExpire(Date refreshExpire) {
		this.refreshExpire = refreshExpire;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
}
