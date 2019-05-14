package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.Map;

import top.microiot.exception.ValueException;

public class ChoiceValue extends DataValue {
	private Map<String, DataValue> value;
	
	public ChoiceValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChoiceValue(AttValueInfo value, ChoiceType type) {
		Map<String, AttValueInfo> structValue = value.getStructValue();
		if(structValue == null || structValue.size() > 1 || structValue.size() == 0) 
			throw new ValueException("choice value size error");
		AttValueInfo choiceValue = null;
		String t = null;
		for(Map.Entry<String, AttValueInfo> entry :  structValue.entrySet()) {
			t =entry.getKey();
			choiceValue = entry.getValue();
		}
		
		AttributeType attType = type.getAttTypes().get(t);
		DataValue v = DataValue.getDataValue(choiceValue, attType.getDataType());
		this.value = new HashMap<String, DataValue>();
		this.value.put(t, v);
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
