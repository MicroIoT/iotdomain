package top.microiot.dto;

import java.util.Map;

import javax.validation.constraints.NotEmpty;

/**
 * 场地输入信息类。
 *
 * @author 曹新宇
 */
public class SiteInfo<T> {
	@NotEmpty(message="site name can't be empty")
	private String name;
	private String parentId;
	@NotEmpty(message="site type can't be empty")
	private String siteType;
	private Map<String, T> attInfos;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public Map<String, T> getAttInfos() {
		return attInfos;
	}
	public void setAttInfos(Map<String, T> attInfos) {
		this.attInfos = attInfos;
	}
	
}
