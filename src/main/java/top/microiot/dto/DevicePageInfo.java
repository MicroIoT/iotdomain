package top.microiot.dto;

/**
 * 设备查询条件类。
 *
 * @author 曹新宇
 */
public class DevicePageInfo extends PageInfo {
	private String locationId;
	private String name;
	private String deviceTypeId;
	private String domainId;
	
	public DevicePageInfo() {
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

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
}
