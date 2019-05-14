package top.microiot.domain.attribute;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import top.microiot.domain.attribute.DataType.Type;

public class ClassTypeDeviceInfo extends AttTypeInfo {

	public ClassTypeDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassTypeDeviceInfo(String name, String description, @Valid List<? extends  IDeviceAttTypeInfo> additional) {
		super(name, Type.Class, description, null, null, null);
		List<AttTypeInfo> a = new ArrayList<AttTypeInfo>();
		for(IDeviceAttTypeInfo deviceAttTypeInfo : additional) {
			a.add((AttTypeInfo) deviceAttTypeInfo);
		}
		this.setAdditional(a);
	}

}
