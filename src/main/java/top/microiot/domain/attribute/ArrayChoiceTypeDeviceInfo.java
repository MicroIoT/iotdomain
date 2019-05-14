package top.microiot.domain.attribute;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ArrayChoiceTypeDeviceInfo extends ArrayChoiceTypeInfo implements IDeviceAttTypeInfo {

	public ArrayChoiceTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayChoiceTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, @Valid List<StructTypeInfo> additional) {
		super(name, description, optional, additional);
		this.setAttribute(get, set, report);
	}

}
