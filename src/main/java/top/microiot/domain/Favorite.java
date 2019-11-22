package top.microiot.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 收藏类。收藏场地或设备，方便用户使用。
 *
 * @author 曹新宇
 */
@CompoundIndex(name = "name_type_user_idx", def = "{'name' : 1, 'user': 1}", unique = true)
@Document
public class Favorite  implements IoTObject{
	@Id
    private String id;
	private String name;
	@DBRef
	private ManagedObject mo;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date time;
	@DBRef(lazy=true)
	@JsonIgnore
	private User user;
	@DBRef
	private Domain domain;
	
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(String name, ManagedObject mo, User user, Domain domain) {
		super();
		this.name = name;
		this.mo = mo;
		this.time = new Date();
		this.user = user;
		this.domain = domain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ManagedObject getMo() {
		return mo;
	}

	public void setMo(ManagedObject mo) {
		this.mo = mo;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}
}
