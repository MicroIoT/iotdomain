package top.microiot.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HttpSession {
	private String username;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Notification.NOTIFY_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date lastRequest;
	private String sessionId;
	private boolean expired;
	public HttpSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HttpSession(String username, Date lastRequest, String sessionId, boolean expired) {
		super();
		this.username = username;
		this.lastRequest = lastRequest;
		this.sessionId = sessionId;
		this.expired = expired;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getLastRequest() {
		return lastRequest;
	}
	public void setLastRequest(Date lastRequest) {
		this.lastRequest = lastRequest;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
}
