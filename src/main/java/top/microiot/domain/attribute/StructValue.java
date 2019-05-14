package top.microiot.domain.attribute;

import java.util.Map;

public class StructValue extends DataValue {
	private Map<String, DataValue> value;
	
	public StructValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StructValue(AttValueInfo value, StructType type) {
		AttributeValues attributes = new AttributeValues(value.getStructValue(), type.getAttTypes());
		this.value = attributes.getAttributes();
	}
	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return null;
	}
	public Map<String, DataValue> getValue() {
		return value;
	}
	public void setValue(Map<String, DataValue> value) {
		this.value = value;
	}
}
