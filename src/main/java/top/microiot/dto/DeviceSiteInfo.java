package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class DeviceSiteInfo {
	@NotEmpty(message="site can't be empty")
	private String site;
	@NotEmpty(message="site type can't be empty")
	private String siteType;
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String sitType) {
		this.siteType = sitType;
	}
}
