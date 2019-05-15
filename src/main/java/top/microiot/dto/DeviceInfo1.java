package top.microiot.dto;

import java.util.Map;

import javax.validation.constraints.NotEmpty;

/**
 * 设备输入信息类。
 *
 * @author 曹新宇
 */
public class DeviceInfo1<T> {
	@NotEmpty(message="device name can't be empty")
	private String deviceName;
	private String simNo;
	@NotEmpty(message="key can't be empty")
	private String type;
	private String siteId;
	private Map<String, T> attInfos;
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getSimNo() {
		return simNo;
	}
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public Map<String, T> getAttInfos() {
		return attInfos;
	}
	public void setAttInfos(Map<String, T> attInfos) {
		this.attInfos = attInfos;
	}
}
