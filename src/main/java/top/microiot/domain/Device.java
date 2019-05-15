package top.microiot.domain;

import java.util.Map;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import top.microiot.domain.attribute.AttributeType;
import top.microiot.domain.attribute.DataValue;

/**
 * 设备类。
 *
 * @author 曹新宇
 */
@CompoundIndex(name = "sim_type_idx", def = "{'simNo' : 1, 'deviceType' : 1}", unique = true)
@Document
public class Device extends NotifyObject{
	private String deviceName;
	private String simNo;
	private boolean connected;
	@DBRef
	private DeviceType deviceType;
	private Map<String, DataValue> attributes;
	@DBRef
	private Site site;
	private User deviceAccount;
	
	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Device(String deviceName, String simNo, DeviceType deviceType, Map<String, DataValue> attributes, Site site, User deviceAccount) {
		super();
		this.deviceName = deviceName;
		this.simNo = simNo;
		this.connected = false;
		this.deviceType = deviceType;
		this.attributes = attributes;
		this.site = site;
		this.deviceAccount = deviceAccount;
	}
	
	public String getSimNo() {
		return simNo;
	}
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	public DeviceType getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	public Map<String, DataValue> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, DataValue> attributes) {
		this.attributes = attributes;
	}
	public User getDeviceAccount() {
		return deviceAccount;
	}
	public void setDeviceAccount(User deviceAccount) {
		this.deviceAccount = deviceAccount;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public boolean isConnected() {
		return connected;
	}
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	public String getString() {
		return this.getDeviceName() + this.getDeviceType().getName();
	}
	@JsonIgnore
	@Override
	public Map<String, AttributeType> getAlarmTypes() {
		return getDeviceType().getAlarmTypes();
	}
	@Override
	public String getType() {
		return NotifyObject.DEVICE;
	}
}
