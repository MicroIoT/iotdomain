package top.microiot.dto;

public class EventPageInfo extends NotificationPageInfo {
	private String deviceId;
	private String attribute;
	
	public EventPageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
}
