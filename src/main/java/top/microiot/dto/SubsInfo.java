package top.microiot.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

public class SubsInfo {
	@NotEmpty(message="deviceId can't be empty")
	private String deviceId;
	@NotNull(message="subscribe can't be empty")
	private boolean subscribe;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}
}
