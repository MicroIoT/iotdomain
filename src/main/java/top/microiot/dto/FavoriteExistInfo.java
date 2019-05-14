package top.microiot.dto;

import javax.validation.constraints.NotNull;

import top.microiot.domain.Favorite.Type;

public class FavoriteExistInfo {
	@NotNull(message="favorite type can't be empty")
	private Type type;
	@NotNull(message="favorite id can't be empty")
	private String favoriteId;
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
}
