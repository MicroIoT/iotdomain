package top.microiot.domain.attribute;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import top.microiot.exception.ValueException;

public class DateTimeType extends DataType {
	public static final String FORMAT = "date.format";
	private String format;
	
	public DateTimeType() {
		super(Type.DateTime);
		// TODO Auto-generated constructor stub
	}

	public DateTimeType(Map<String, String> format) {
		super(Type.DateTime);
		this.format = format.get(FORMAT);
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getValue() == null)
			return false;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);  
		try {
			dateFormat.parse(value.getValue());
			return true;
		} catch (ParseException e) {
			return false;
		} 
	}

	@Override
	public AttValueInfo getAttValue(Object object) {
		if(object instanceof Date) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format); 
			
			return new AttValueInfo(dateFormat.format(object));
		}
		else
			throw new ValueException("expected data type is java.util.date, but not " + object.getClass().getName());
	}

	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof DateTimeValue) {
			return ((DateTimeValue)value).getValue();
		}
		else
			throw new ValueException("expected data value is DateTimeValue, but not " + value.getClass().getName());
	}

	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new DateTimeValue(a, this);
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		// TODO Auto-generated method stub
		return getData(new DateTimeValue(value, this), Date.class);
	}
}
