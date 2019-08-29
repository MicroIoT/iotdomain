package top.microiot.dto;

import javax.validation.constraints.NotNull;

public class FavoriteExistInfo {
	@NotNull(message="favorite id can't be empty")
	private String favoriteId;
	public String getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}
}
