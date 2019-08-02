package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

/**
 * 将设备添加入设备组输入信息类。
 *
 * @author 曹新宇
 */
public class DeviceAddGroupInfo {
	@NotEmpty(message="device id can't be empty")
	private String deviceId;
	@NotEmpty(message="device group id can't be empty")
	private String groupId;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
