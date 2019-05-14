package top.microiot.domain.attribute;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class StructTypeDeviceInfo extends StructTypeInfo implements IDeviceAttTypeInfo {

	public StructTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StructTypeDeviceInfo(Boolean get, Boolean set, Boolean report, String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, @Valid List<? extends AttTypeInfo> additional) {
		super(name, description, optional, additional);
		this.setAttribute(get, set, report);
	}

}
