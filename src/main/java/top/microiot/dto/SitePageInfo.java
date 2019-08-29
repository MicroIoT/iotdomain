package top.microiot.dto;

/**
 * 场地查询条件类。
 *
 * @author 曹新宇
 */
public class SitePageInfo extends PageInfo {
	private String locationId;
	private String name;
	private String siteTypeId;
	private String domainId;
	
	public SitePageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(String siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
}
