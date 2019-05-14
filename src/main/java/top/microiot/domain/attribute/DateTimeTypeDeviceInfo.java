package top.microiot.domain.attribute;

import javax.validation.constraints.NotNull;

public class DateTimeTypeDeviceInfo extends DateTimeTypeInfo implements IDeviceAttTypeInfo {

	public DateTimeTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateTimeTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, String format) {
		super(name, description, optional, format);
		this.setAttribute(get, set, report);
	}

}
