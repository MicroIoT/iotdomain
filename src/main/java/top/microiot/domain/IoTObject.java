package top.microiot.domain;

import top.microiot.exception.ValueException;

/**
 * 客户端可查询对象。
 *
 * @author 曹新宇
 */
public enum IoTObject {
	device("devices", "top.microiot.domain.Device"), 
	devicetype("devicetypes", "top.microiot.domain.DeviceType"), 
	site("sites", "top.microiot.domain.Site"), 
	sitetype("sitetypes", "top.microiot.domain.SiteType"), 
	event("events", "top.microiot.domain.Event"), 
	alarm("alarms", "top.microiot.domain.Alarm");
	
	private String name;
	private String className;
	
	private IoTObject(String name, String className) {
		this.name = name;
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}
	
	public Class<?> getIoT(){
		try {
			return Class.forName(getClassName());
		} catch (ClassNotFoundException e) {
			throw new ValueException("class not found: " + getName());
		}
	}
}
