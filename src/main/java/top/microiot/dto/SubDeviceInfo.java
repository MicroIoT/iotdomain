package top.microiot.dto;

public class SubDeviceInfo<T> extends DeviceInfo<T> {
	private String gatewayId;

	public String getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}
}
