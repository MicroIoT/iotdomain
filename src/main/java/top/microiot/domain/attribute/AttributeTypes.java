package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import top.microiot.exception.ConflictException;

public class AttributeTypes {
	private Map<String, AttributeType> attTypes = new HashMap<String, AttributeType>();
	
	public AttributeTypes(List<? extends AttTypeInfo> additional){
		if(additional == null)
			attTypes = null;
		else {
			for (AttTypeInfo type : additional) {
				if (attTypes.containsKey(type.getName())) {
					String error = type.getName();
					throw new ConflictException(error);
				}
				AttributeType attType = getAttType(type);
				attTypes.put(type.getName(), attType);
			}
		}
	}
	
	public Map<String, AttributeType> getAttTypes() {
		return attTypes;
	}

	protected AttributeType getAttType(AttTypeInfo type) {
		return new AttributeType(type);
	}
}
