package top.microiot.dto;

import top.microiot.domain.Favorite.Type;

/**
 * 收藏查询条件类。
 *
 * @author 曹新宇
 */
public class FavoritePageInfo extends PageInfo {
	private String name;
	private Type type;

	public FavoritePageInfo() {
		super();
		// TODO Auto-generated constructor stub
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
}
