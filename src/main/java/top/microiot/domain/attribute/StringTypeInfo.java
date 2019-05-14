package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class StringTypeInfo extends AttTypeInfo {

	public StringTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StringTypeInfo(String name, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, int min, int max) {
		super(name, Type.String, description, optional, null, null);
		Map<String, String> dataTypeInfos = new HashMap<String, String>();
		dataTypeInfos.put(StringType.MIN, Integer.toString(min));
		dataTypeInfos.put(StringType.MAX, Integer.toString(max));
		this.setDataTypeInfos(dataTypeInfos);
	}

}
