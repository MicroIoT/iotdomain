package top.microiot.domain.attribute;

import java.util.List;

import javax.validation.Valid;

import top.microiot.domain.attribute.DataType.Type;

public class ClassTypeInfo extends AttTypeInfo {

	public ClassTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassTypeInfo(String name, String description, @Valid List<? extends AttTypeInfo> additional) {
		super(name, Type.Class, description, false, null, additional);
		// TODO Auto-generated constructor stub
	}

}
