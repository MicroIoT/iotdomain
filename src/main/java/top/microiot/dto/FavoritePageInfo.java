package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

import top.microiot.domain.ManagedObject;

/**
 * 收藏查询条件类。
 *
 * @author 曹新宇
 */
public class FavoritePageInfo extends PageInfo {
	@NotEmpty(message="domain id can't be empty")
	private String domainId;
	private String name;
	private ManagedObject.Type type;

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

	public ManagedObject.Type getType() {
		return type;
	}

	public void setType(ManagedObject.Type type) {
		this.type = type;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
}
