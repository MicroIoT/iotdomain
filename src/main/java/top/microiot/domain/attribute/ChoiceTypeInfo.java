package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class ChoiceTypeInfo extends AttTypeInfo {

	public ChoiceTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChoiceTypeInfo(String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, 
			@Valid List<StructTypeInfo> additional) {
		super(name, Type.Choice, description, optional, new HashMap<String, String>(), additional);
		// TODO Auto-generated constructor stub
	}

}
