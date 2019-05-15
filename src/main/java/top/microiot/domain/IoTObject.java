package top.microiot.domain;

import top.microiot.exception.ValueException;

/**
 * 查询对象。
 *
 * @author 曹新宇
 */
public enum IoTObject {
	device("device", "top.microiot.domain.Device"), 
	devicetype("devicetype", "top.microiot.domain.DeviceType"), 
	site("site", "top.microiot.domain.Site"), 
	sitetype("sitetype", "top.microiot.domain.SiteType"), 
	event("event", "top.microiot.domain.Event"), 
	alarm("alarm", "top.microiot.domain.Alarm");
	
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
