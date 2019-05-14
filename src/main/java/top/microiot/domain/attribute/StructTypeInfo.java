package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class StructTypeInfo extends AttTypeInfo {

	public StructTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StructTypeInfo(String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, 
			@Valid List<? extends AttTypeInfo> additional) {
		super(name, Type.Struct, description, optional, new HashMap<String, String>(), additional);
		// TODO Auto-generated constructor stub
	}

}
