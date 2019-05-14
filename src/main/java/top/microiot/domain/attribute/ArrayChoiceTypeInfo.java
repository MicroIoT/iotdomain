package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class ArrayChoiceTypeInfo extends AttTypeInfo {

	public ArrayChoiceTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayChoiceTypeInfo(String name, 
			String description, @NotNull(message = "optional can't be empty") Boolean optional,
			@Valid List<StructTypeInfo> additional) {
		super(name, Type.Array, description, optional, null, additional);
		Map<String, String> dataTypeInfos = new HashMap<String, String>();
		dataTypeInfos.put(ArrayType.TYPE, Type.Choice.toString());
		this.setDataTypeInfos(dataTypeInfos);
	}

}
