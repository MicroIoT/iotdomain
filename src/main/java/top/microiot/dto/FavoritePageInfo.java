package top.microiot.dto;

/**
 * 收藏查询条件类。
 *
 * @author 曹新宇
 */
public class FavoritePageInfo extends PageInfo {
	private String name;
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
