package top.microiot.domain.attribute;

import top.microiot.exception.ValueException;

public class StringValue extends DataValue {
	private String value;
	
	public StringValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StringValue(AttValueInfo value, StringType type){
		if(!type.isValid(value))
			throw new ValueException("invalid string value");
		this.value = value.getValue();
	}
	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
