package top.microiot.domain.attribute;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ArrayEnumTypeDeviceInfo extends ArrayEnumTypeInfo implements IDeviceAttTypeInfo {

	public ArrayEnumTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayEnumTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, List<String> enums) {
		super(name, description, optional, enums);
		this.setAttribute(get, set, report);
	}

}
