package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

/**
 * 重命名设备类型输入信息类。
 *
 * @author 曹新宇
 */
public class DeviceTypeRenameInfo {
	@NotEmpty(message="device type id can't be empty")
	private String id;
	@NotEmpty(message="name can't be empty")
	private String name;
	
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
}
