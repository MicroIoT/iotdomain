package top.microiot.domain.attribute;

import top.microiot.exception.ValueException;

public class DecimalType extends DataType {

	public DecimalType() {
		super(Type.Decimal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getValue() == null)
			return false;
		try{
			Double.parseDouble(value.getValue());
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	@Override
	public AttValueInfo getAttValue(Object object) {
		if(object instanceof Double) {
			return new AttValueInfo(object.toString());
		}
		else
			throw new ValueException("expected data type is double or Double, but not " + object.getClass().getName());
	}

	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof DecimalValue) {
			return ((DecimalValue)value).getValue();
		}
		else
			throw new ValueException("expected data value is DecimalValue, but not " + value.getClass().getName());
	}

	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new DecimalValue(a.getValue());
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		// TODO Auto-generated method stub
		return getData(new DecimalValue(value.getValue()), Double.class);
	}

}
