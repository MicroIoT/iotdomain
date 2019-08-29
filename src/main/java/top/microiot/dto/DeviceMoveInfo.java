package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

/**
 * 移动设备输入信息类。
 *
 * @author 曹新宇
 */
public class DeviceMoveInfo {
	@NotEmpty(message="device id can't be empty")
	private String id;
	private String locationId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String deviceId) {
		this.locationId = deviceId;
	}
}
