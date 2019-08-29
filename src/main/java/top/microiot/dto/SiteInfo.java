package top.microiot.dto;

import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 场地输入信息类。
 *
 * @author 曹新宇
 */
public class SiteInfo<T> {
	@NotEmpty(message="site name can't be empty")
	private String name;
	@NotNull(message="location can't be empty")
	private String locationId;
	@NotEmpty(message="site type can't be empty")
	private String siteType;
	private Map<String, T> attInfos;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
}
