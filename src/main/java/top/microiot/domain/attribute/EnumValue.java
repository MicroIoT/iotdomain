package top.microiot.domain.attribute;

import top.microiot.exception.ValueException;

public class EnumValue extends DataValue {
	private String value;
	
	public EnumValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnumValue(AttValueInfo value, EnumType enumType){
		this.value = value.getValue();
		if(!enumType.isValid(value))
			throw new ValueException("invalid enum value");
	}
	@Override
	public String getString() {
		return value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
