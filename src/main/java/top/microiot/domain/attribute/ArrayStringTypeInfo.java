package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class ArrayStringTypeInfo extends AttTypeInfo {

	public ArrayStringTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayStringTypeInfo(String name, int min, int max,
			String description, @NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, Type.Array, description, optional, null, null);
		Map<String, String> dataTypeInfos = new HashMap<String, String>();
		dataTypeInfos.put(ArrayType.TYPE, Type.String.toString());
		dataTypeInfos.put(StringType.MIN, Integer.toString(min));
		dataTypeInfos.put(StringType.MAX, Integer.toString(max));
		this.setDataTypeInfos(dataTypeInfos);
	}

}
