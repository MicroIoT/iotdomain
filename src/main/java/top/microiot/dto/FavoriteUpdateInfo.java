package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class FavoriteUpdateInfo {
	@NotEmpty(message="favorite id can't be empty")
	private String favoriteId;
	@NotEmpty(message="favorite name can't be empty")
	private String newName;
	public String getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(String favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
}
