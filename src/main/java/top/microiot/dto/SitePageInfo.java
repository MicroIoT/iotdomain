package top.microiot.dto;

/**
 * 场地查询条件类。
 *
 * @author 曹新宇
 */
public class SitePageInfo extends PageInfo {
	private String parentId;
	private String siteName;
	private String siteTypeId;

	public SitePageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(String siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	
}
