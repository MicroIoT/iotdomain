package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class ArrayDecimalTypeInfo extends AttTypeInfo {

	public ArrayDecimalTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayDecimalTypeInfo(String name, 
			String description, @NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, Type.Array, description, optional, null, null);
		Map<String, String> dataTypeInfos = new HashMap<String, String>();
		dataTypeInfos.put(ArrayType.TYPE, Type.Decimal.toString());
		this.setDataTypeInfos(dataTypeInfos);
	}

}
