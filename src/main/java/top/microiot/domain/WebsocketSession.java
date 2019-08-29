package top.microiot.domain;

import java.util.Set;

/**
 * 当前系统登录的websocket会话类。
 *
 * @author 曹新宇
 */
public class WebsocketSession {
	private String username;
	private Set<String> sessions;
	
	public WebsocketSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebsocketSession(String username, Set<String> sessions) {
		super();
		this.username = username;
		this.sessions = sessions;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<String> getSessions() {
		return sessions;
	}
	public void setSessions(Set<String> sessions) {
		this.sessions = sessions;
	}
}
