package top.microiot.domain.attribute;

import java.util.HashMap;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class BoolTypeInfo extends AttTypeInfo {

	public BoolTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoolTypeInfo(String name, String description, @NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, Type.Bool, description, optional, new HashMap<String, String>(), null);
		// TODO Auto-generated constructor stub
	}
	
}
