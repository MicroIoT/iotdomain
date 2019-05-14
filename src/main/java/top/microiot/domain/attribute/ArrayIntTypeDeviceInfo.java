package top.microiot.domain.attribute;

import javax.validation.constraints.NotNull;

public class ArrayIntTypeDeviceInfo extends ArrayIntTypeInfo implements IDeviceAttTypeInfo {

	public ArrayIntTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayIntTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, description, optional);
		setAttribute(get, set, report);
	}
}
