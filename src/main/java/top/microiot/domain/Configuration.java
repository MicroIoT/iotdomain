package top.microiot.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 告警配置类。配置告警是否置顶，是否静音。
 *
 * @author 曹新宇
 */
@CompoundIndex(name = "user_object_idx", def = "{'user' : 1, 'notifyObject' : 1}", unique = true)
@Document
public class Configuration  implements IoTObject{
	@Id
    private String id;
	@DBRef(lazy=true)
	@JsonIgnore
	private User user;
	@DBRef
	private ManagedObject notifyObject;
	@DBRef
	private Domain domain;
	private boolean silent;
	private boolean top;
	private boolean subscribe;
	
	public Configuration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Configuration(User user, ManagedObject notifyObject) {
		super();
		this.user = user;
		this.notifyObject = notifyObject;
		this.domain = notifyObject.getDomain();
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
	public ManagedObject getNotifyObject() {
		return notifyObject;
	}
	public void setNotifyObject(ManagedObject device) {
		this.notifyObject = device;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
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
	public boolean isSubscribe() {
		return subscribe;
	}
	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}
}
