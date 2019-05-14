package top.microiot.domain.attribute;

import javax.validation.constraints.NotNull;

public class StringTypeDeviceInfo extends StringTypeInfo implements IDeviceAttTypeInfo {

	public StringTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StringTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, int min, int max) {
		super(name, description, optional, min, max);
		this.setAttribute(get, set, report);
	}

}
