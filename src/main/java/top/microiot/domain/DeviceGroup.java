package top.microiot.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 设备组类。设备组由一组相互协作的设备组成，设备组内的设备之间可以相互订阅接收告警，获取、设置属性值，执行操作。
 *
 * @author 曹新宇
 */
@Document
public class DeviceGroup implements IoTObject{
	@Id
    private String id;
	@Indexed(unique=true)
	private String name;
	@DBRef
	private List<Device> devices;
	@DBRef
	private Domain domain;
	
	public DeviceGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceGroup(String name, List<Device> devices, Domain domain) {
		super();
		this.name = name;
		this.devices = devices;
		this.domain = domain;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
}
