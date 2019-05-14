package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class DateTimeTypeInfo extends AttTypeInfo {

	public DateTimeTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateTimeTypeInfo(String name, String description, @NotNull(message = "optional can't be empty") Boolean optional, String format) {
		super(name, Type.DateTime, description, optional, null, null);
		Map<String, String> dataTypeInfos = new HashMap<String, String>();
		dataTypeInfos.put(DateTimeType.FORMAT, format);
		this.setDataTypeInfos(dataTypeInfos);
	}

}
