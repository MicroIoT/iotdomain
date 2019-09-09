package top.microiot.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class DeviceGroupInfo {
	@NotEmpty(message="device group name can't be empty")
	private String name;
	@NotEmpty(message="devices can't be empty")
	private List<String> devices;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getDevices() {
		return devices;
	}
	public void setDevices(List<String> devices) {
		this.devices = devices;
	}
}
