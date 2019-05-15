package top.microiot.dto;

/**
 * 事件查询条件类。
 *
 * @author 曹新宇
 */
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
