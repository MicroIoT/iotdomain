package top.microiot.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 告警配置类。
 *
 * @author 曹新宇
 */
@CompoundIndex(name = "user_object_idx", def = "{'user' : 1, 'notifyObject' : 1}", unique = true)
@Document
public class Configuration {
	@Id
    private String id;
	@DBRef(lazy=true)
	@JsonIgnore
	private User user;
	@DBRef
	private NotifyObject notifyObject;
	private boolean silent;
	private boolean top;
	
	public Configuration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Configuration(User user, NotifyObject notifyObject) {
		super();
		this.user = user;
		this.notifyObject = notifyObject;
		this.silent = false;
		this.top = false;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public NotifyObject getNotifyObject() {
		return notifyObject;
	}
	public void setNotifyObject(NotifyObject device) {
		this.notifyObject = device;
	}
	public boolean isSilent() {
		return silent;
	}
	public void setSilent(boolean silent) {
		this.silent = silent;
	}
	public boolean isTop() {
		return top;
	}
	public void setTop(boolean top) {
		this.top = top;
	}
}
