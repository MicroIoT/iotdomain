package top.microiot.domain.attribute;

import javax.validation.constraints.NotNull;

public class ArrayDateTypeDeviceInfo extends ArrayDateTypeInfo implements IDeviceAttTypeInfo {

	public ArrayDateTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayDateTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String format, String description,
			@NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, format, description, optional);
		this.setAttribute(get, set, report);
	}

}
