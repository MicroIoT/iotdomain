package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.Map;

import top.microiot.exception.NotFoundException;
import top.microiot.exception.ValueException;

public class AttributeValues {
	private Map<String, AttValueInfo> attValueInfos;
	private Map<String, AttributeType> attTypes;
	
	public AttributeValues(Map<String, AttValueInfo> attValueInfos, Map<String, AttributeType> attTypes){
		this.attValueInfos = attValueInfos;
		this.attTypes = attTypes;
	}

	public Map<String, DataValue> getAttributes() {
		Map<String, DataValue> attributes = new HashMap<String, DataValue>();
		
		if(attTypes != null) {
			for (String key : attTypes.keySet()) {
				AttributeType attType = attTypes.get(key);
				if(!attType.isOptional() && (attValueInfos == null || !attValueInfos.containsKey(key))){
					throw new NotFoundException("attribute: " + key);
				}else if(attValueInfos.containsKey(key)){
					AttValueInfo value = attValueInfos.get(key);
					if((value == null || value.isEmpty()) && attType.isOptional())
						;
					else if((value == null || value.isEmpty()) && !attType.isOptional())
						throw new NotFoundException("attribute: " + key);
					else{
						DataType dataType = attType.getDataType();
						if(!dataType.isValid(value))
							throw new ValueException("attribute: "+ key + " is not valid value");
						DataValue dataValue = DataValue.getDataValue(value, dataType);
						attributes.put(key, dataValue);
					}
				}
			}
		}
		return attributes;
	}
}
