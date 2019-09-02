package top.microiot.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@CompoundIndex(name = "user_key_idx", def = "{'user' : 1, 'key' : 1}", unique = true)
@Document
public class Session {
	@Id
	private String id;
	private String key;
	private Object value;
	@DBRef
	private User user;
	
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Session(String key, Object value, User user) {
		super();
		this.key = key;
		this.value = value;
		this.user = user;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
