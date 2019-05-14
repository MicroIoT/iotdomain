package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class ArrayStructTypeInfo extends AttTypeInfo {

	public ArrayStructTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayStructTypeInfo(String name, 
			String description, @NotNull(message = "optional can't be empty") Boolean optional,
			@Valid List<? extends AttTypeInfo> additional) {
		super(name, Type.Array, description, optional, null, additional);
		Map<String, String> dataTypeInfos = new HashMap<String, String>();
		dataTypeInfos.put(ArrayType.TYPE, Type.Struct.toString());
		this.setDataTypeInfos(dataTypeInfos);
	}

}
