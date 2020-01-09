package top.microiot.dto;

public class LoginUserPageInfo extends PageInfo {
	private Boolean isDevice;
	private Boolean isExpire;
	public Boolean getIsDevice() {
		return isDevice;
	}
	public void setIsDevice(Boolean isDevice) {
		this.isDevice = isDevice;
	}
	public Boolean getIsExpire() {
		return isExpire;
	}
	public void setIsExpire(Boolean isExpire) {
		this.isExpire = isExpire;
	}
}
