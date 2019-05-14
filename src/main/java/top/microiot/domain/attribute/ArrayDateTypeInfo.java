package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class ArrayDateTypeInfo extends AttTypeInfo {

	public ArrayDateTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayDateTypeInfo(String name, String format,
			String description, @NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, Type.Array, description, optional, null, null);
		Map<String, String> dataTypeInfos = new HashMap<String, String>();
		dataTypeInfos.put(ArrayType.TYPE, Type.DateTime.toString());
		dataTypeInfos.put(DateTimeType.FORMAT, format);
		this.setDataTypeInfos(dataTypeInfos);
	}

}
