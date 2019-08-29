package top.microiot.dto;

import javax.validation.constraints.NotNull;

/**
 * 场地类型查询条件类。
 *
 * @author 曹新宇
 */
public class SiteTypePageInfo extends PageInfo {
	@NotNull(message="domain id can't be null")
	private String domainId;
	
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	
}
