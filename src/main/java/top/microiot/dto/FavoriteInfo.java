package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

/**
 * 收藏输入信息类。
 *
 * @author 曹新宇
 */
public class FavoriteInfo {
	@NotEmpty(message="favorite name can't be empty")
	private String name;
	@NotEmpty(message="id can't be empty")
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
