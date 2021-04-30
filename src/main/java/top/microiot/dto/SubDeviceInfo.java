package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class SubDeviceInfo<T> extends DeviceInfo<T> {
	@NotEmpty(message="gatewayId can't be empty")
	private String gatewayId;

	public String getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}
}
