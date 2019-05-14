package top.microiot.domain.attribute;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class DecimalTypeInfo extends AttTypeInfo {

	public DecimalTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DecimalTypeInfo(String name, 
			String description, @NotNull(message = "optional can't be empty") Boolean optional) {
		super(name, Type.Decimal, description, optional, null, null);
		// TODO Auto-generated constructor stub
	}

}
