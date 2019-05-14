package top.microiot.dto;

import javax.validation.constraints.NotNull;

import top.microiot.domain.Favorite.Type;

import javax.validation.constraints.NotEmpty;

public class FavoriteInfo {
	@NotEmpty(message="favorite name can't be empty")
	private String name;
	@NotNull(message="favorite type can't be empty")
	private Type type;
	@NotEmpty(message="id can't be empty")
	private String id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
