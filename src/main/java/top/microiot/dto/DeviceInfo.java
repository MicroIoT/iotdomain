package top.microiot.dto;

import java.util.Map;

import javax.validation.constraints.NotEmpty;

/**
 * 设备输入信息类。
 *
 * @author 曹新宇
 */
public class DeviceInfo<T> {
	@NotEmpty(message="device name can't be empty")
	private String name;
	@NotEmpty(message="device type can't be empty")
	private String deviceType;
	@NotEmpty(message="locationId can't be empty")
	private String locationId;
	private Map<String, T> attInfos;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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
