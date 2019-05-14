package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class ArrayEnumTypeInfo extends AttTypeInfo {

	public ArrayEnumTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayEnumTypeInfo(String name, 
			String description, @NotNull(message = "optional can't be empty") Boolean optional, List<String> enums) {
		super(name, Type.Array, description, optional, null, null);
		Map<String, String> dataTypeInfos = new HashMap<String, String>();
		dataTypeInfos.put(ArrayType.TYPE, Type.Enum.toString());
		String enumtype = "";
		for(String e : enums) {
			enumtype += e;
			enumtype += ";";
		}
			
		dataTypeInfos.put(EnumType.ENUM, enumtype);
		this.setDataTypeInfos(dataTypeInfos);
	}

}
