package top.microiot.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

public class ConfigInfo {
	@NotEmpty(message="objectId can't be empty")
	private String notifyObjectId;
	@NotEmpty(message="key can't be empty")
	private String key;
	@NotNull(message="value can't be empty")
	private boolean value;
	public String getNotifyObjectId() {
		return notifyObjectId;
	}
	public void setNotifyObjectId(String notifyObjectId) {
		this.notifyObjectId = notifyObjectId;
	}
	public boolean getValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
