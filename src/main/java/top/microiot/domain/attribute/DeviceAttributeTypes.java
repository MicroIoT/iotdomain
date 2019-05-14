package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import top.microiot.exception.ConflictException;

public class DeviceAttributeTypes {
	private Map<String, DeviceAttributeType> attTypes = new HashMap<String, DeviceAttributeType>();
	
	public DeviceAttributeTypes(List<? extends AttTypeInfo> additional){
		if(additional == null)
			attTypes = null;
		else {
			for (AttTypeInfo type : additional) {
				if (attTypes.containsKey(type.getName())) {
					String error = type.getName();
					throw new ConflictException(error);
				}
				DeviceAttributeType attType = getAttType(type);
				attTypes.put(type.getName(), attType);
			}
		}
	}

	public Map<String, DeviceAttributeType> getAttTypes() {
		return attTypes;
	}

	protected DeviceAttributeType getAttType(AttTypeInfo type) {
		return new DeviceAttributeType(type);
	}

}
