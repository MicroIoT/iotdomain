package top.microiot.domain.attribute;

import java.util.Map;

import top.microiot.exception.ValueException;

public class StringType extends DataType {
	public static final String MAX = "string.max";
	public static final String MIN = "string.min";
	private Integer min;
	private Integer max;
	
	public StringType() {
		super(Type.String);
		// TODO Auto-generated constructor stub
	}
	public StringType(Integer min, Integer max) {
		super(Type.String);
		this.min = min;
		this.max = max;
	}
	public StringType(Map<String, String> infos){
		super(Type.String);
		if(infos == null){
			this.min = null;
			this.max = null;
		}else {
			try{
				if(infos.get(MIN).length() == 0) 
					this.min = 0;
				else
					this.min = Integer.parseInt(infos.get(MIN));
			}catch(NumberFormatException e){
				throw new ValueException("invalid min definition");
			}
			try{
				if(infos.get(MAX).length() == 0) 
					this.max = 1024;
				else
					this.max = Integer.parseInt(infos.get(MAX));
			}catch(NumberFormatException e){
				throw new ValueException("invalid max definition");
			}
			if(min != null && max != null && min > max)
				throw new ValueException("max not great than min");
		}
		
	}
	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getValue() == null)
			return false;
		if(min != null && value.getValue().length()<min)
			return false;
		if(max != null && value.getValue().length()>max)
			return false;
		return true;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	@Override
	public AttValueInfo getAttValue(Object object) {
		if(object instanceof String) {
			AttValueInfo a = new AttValueInfo(object.toString());
			if(!isValid(a))
				throw new ValueException("expected data type is String, and min length is "+ min + " max length is " + max);
			else
				return a;
		}
		else
			throw new ValueException("expected data type is String, but not " + object.getClass().getName());
	}
	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof StringValue) {
			return ((StringValue)value).getValue();
		}
		else
			throw new ValueException("expected data value is StringValue, but not " + value.getClass().getName());
	}
	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new StringValue(a, this);
	}
	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		// TODO Auto-generated method stub
		return getData(new StringValue(value, this), String.class);
	}

}
