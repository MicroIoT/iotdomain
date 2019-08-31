package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

/**
 * 修改收藏输入信息类。
 *
 * @author 曹新宇
 */
public class FavoriteUpdateInfo {
	@NotEmpty(message="favorite id can't be empty")
	private String id;
	@NotEmpty(message="favorite name can't be empty")
	private String newName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
}
