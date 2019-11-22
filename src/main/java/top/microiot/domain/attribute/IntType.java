package top.microiot.domain.attribute;

import com.fasterxml.jackson.annotation.JsonTypeName;

import top.microiot.exception.ValueException;

@JsonTypeName(DataType.INT)
public class IntType extends DataType {
	public IntType() {
		super(Type.Int);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getValue() == null)
			return false;
		try{
			Integer.parseInt(value.getValue());
			return true;
		}catch( NumberFormatException e){
			return false;
		}
	}

	@Override
	public AttValueInfo getAttValue(Object object) {
		if(object instanceof Integer) {
			return new AttValueInfo(object.toString());
		}
		else
			throw new ValueException("excepted data type is int or Integer, but not " + object.getClass().getName());
	}

	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof IntValue) {
			return ((IntValue)value).getValue();
		}
		else
			throw new ValueException("expected data value is IntValue, but not " + value.getClass().getName());
	}

	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new IntValue(a.getValue());
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		// TODO Auto-generated method stub
		return getData(new IntValue(value.getValue()), Integer.class);
	}


}
