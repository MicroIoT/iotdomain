package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class SubDeviceAlarmInfo extends AlarmInfo {
	@NotEmpty(message="device id can't be empty")
	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
