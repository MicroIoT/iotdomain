package top.microiot.dto;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class DeviceInfo<T> {
	@NotEmpty(message="device name can't be empty")
	private String deviceName;
	@NotEmpty(message="simNo can't be empty")
	private String simNo;
	@NotEmpty(message="device type can't be empty")
	private String type;
	@Valid
	private List<DeviceSiteInfo> sites;
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
	public List<DeviceSiteInfo> getSites() {
		return sites;
	}
	public void setSites(List<DeviceSiteInfo> sites) {
		this.sites = sites;
	}
	public Map<String, T> getAttInfos() {
		return attInfos;
	}
	public void setAttInfos(Map<String, T> attInfos) {
		this.attInfos = attInfos;
	}
}
