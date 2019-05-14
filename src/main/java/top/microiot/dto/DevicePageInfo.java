package top.microiot.dto;

public class DevicePageInfo extends PageInfo {
	private String siteId;
	private String deviceName;
	private String deviceType;

	public DevicePageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	
}
