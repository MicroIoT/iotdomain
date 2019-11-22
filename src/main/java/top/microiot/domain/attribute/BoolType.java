package top.microiot.domain.attribute;

import com.fasterxml.jackson.annotation.JsonTypeName;

import top.microiot.exception.ValueException;

@JsonTypeName(DataType.BOOL)
public class BoolType extends DataType {
	public BoolType() {
		super(Type.Bool);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getValue() == null)
			return false;
		if(value.getValue().equalsIgnoreCase("true") || value.getValue().equalsIgnoreCase("false"))
			return true;
		else
			return false;
	}

	@Override
	public AttValueInfo getAttValue(Object object) {
		if(object instanceof Boolean)
			return new AttValueInfo(object.toString());
		else
			throw new ValueException("expected data type is bool or Boolean, but not " + object.getClass().getName());
	}

	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof BoolValue)
			return ((BoolValue)value).getValue();
		else
			throw new ValueException("expected data value is BoolValue, but not " + value.getClass().getName());
	}

	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new BoolValue(a.getValue());
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		return getData(new BoolValue(value.getValue()), Boolean.class);
	}

}
