package top.microiot.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@CompoundIndex(name = "name_type_user_idx", def = "{'name' : 1, 'type' : 1, 'user': 1}", unique = true)
@Document
public class Favorite {
	public enum Type{
		Device, Site
	}
	@Id
    private String id;
	private String name;
	private Type type;
	private String favoriteId;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date time;
	@DBRef(lazy=true)
	@JsonIgnore
	private User user;
	
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(String name, Type type, String favoriteId, User user) {
		super();
		this.name = name;
		this.type = type;
		this.favoriteId = favoriteId;
		this.time = new Date();
		this.user = user;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
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
}
