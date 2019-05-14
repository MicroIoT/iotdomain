package top.microiot.domain.attribute;

import java.util.ArrayList;
import java.util.List;

public class ArrayValue extends DataValue {
	private List<DataValue> value = new ArrayList<DataValue>();
	
	public ArrayValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayValue(AttValueInfo value, ArrayType type) {
		List<AttValueInfo> valueInfos = value.getArrayValue(); 
		for(AttValueInfo valueInfo : valueInfos) {
			this.value.add(DataValue.getDataValue(valueInfo, type.getDataType()));
		}
			
	}
	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<DataValue> getValue() {
		return value;
	}
	public void setValue(List<DataValue> value) {
		this.value = value;
	}
}
