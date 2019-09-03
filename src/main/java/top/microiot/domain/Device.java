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
@CompoundIndex(name = "name_loc_type_idx", def = "{'name' : 1, 'location' : 1, 'deviceType' : 1}", unique = true)
@Document
public class Device extends ManagedObject{
	private boolean connected;
	@DBRef
	private DeviceType deviceType;
	private Map<String, DataValue> attributes;
	@DBRef
	private ManagedObject location;
	@DBRef
	private Device parent;
	@DBRef
	private Domain domain;
	private User deviceAccount;
	
	public Device() {
		super();
	}
	public Device(String name, DeviceType deviceType, Map<String, DataValue> attributes, ManagedObject location, User deviceAccount) {
		super(name, ManagedObject.DEVICE);
		this.connected = false;
		this.deviceType = deviceType;
		this.attributes = attributes;
		this.location = location;
		this.parent = null;
		this.deviceAccount = deviceAccount;
		this.domain = deviceType.getDomain();
	}
	
	public Device getParent() {
		return parent;
	}
	public void setParent(Device parent) {
		this.parent = parent;
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
	public ManagedObject getLocation() {
		return location;
	}
	public void setLocation(ManagedObject location) {
		this.location = location;
	}
	public boolean isConnected() {
		return connected;
	}
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	public String getString() {
		return this.getName() + this.getDeviceType().getName();
	}
	public String getFullString() {
		return getLocation().getFullString() + getString();
	}
	@JsonIgnore
	@Override
	public Map<String, AttributeType> getAlarmTypes() {
		return getDeviceType().getAlarmTypes();
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
}
