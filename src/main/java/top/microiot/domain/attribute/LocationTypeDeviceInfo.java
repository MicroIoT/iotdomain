package top.microiot.domain.attribute;

import javax.validation.constraints.NotNull;

public class LocationTypeDeviceInfo extends LocationTypeInfo implements IDeviceAttTypeInfo {

	public LocationTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, description, optional);
		this.setAttribute(get, set, report);
	}

}
