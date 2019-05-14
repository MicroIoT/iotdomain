package top.microiot.domain.attribute;

import javax.validation.constraints.NotNull;

public class ArrayStringTypeDeviceInfo extends ArrayStringTypeInfo implements IDeviceAttTypeInfo {

	public ArrayStringTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayStringTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, int min, int max, String description,
			@NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, min, max, description, optional);
		this.setAttribute(get, set, report);
	}

}
