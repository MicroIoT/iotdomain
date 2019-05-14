package top.microiot.domain.attribute;

import javax.validation.constraints.NotNull;

public class ArrayBoolTypeDeviceInfo extends ArrayBoolTypeInfo  implements IDeviceAttTypeInfo{

	public ArrayBoolTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayBoolTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, description, optional);
		this.setAttribute(get, set, report);
	}

}
