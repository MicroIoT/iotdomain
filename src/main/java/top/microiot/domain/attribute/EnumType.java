package top.microiot.domain.attribute;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeName;

import top.microiot.exception.ValueException;

@JsonTypeName(DataType.ENUM)
public class EnumType extends DataType {
	public static final String ENUM = "enum.value";
	private List<String> enumType;
	
	public EnumType() {
		super(Type.Enum);
		// TODO Auto-generated constructor stub
	}

	public EnumType(List<String> enumType) {
		super(Type.Enum);
		this.enumType = enumType;
	}

	public EnumType(Map<String, String> type){
		super(Type.Enum);
		this.enumType = Arrays.asList(type.get(ENUM).split(";"));
	}

	public List<String> getEnumType() {
		return enumType;
	}

	public void setEnumType(List<String> enumType) {
		this.enumType = enumType;
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getValue() == null)
			return false;
		if(enumType.contains(value.getValue()))
			return true;
		else
			return false;
	}

	@Override
	public AttValueInfo getAttValue(Object object) {
		if(object.getClass().isEnum() && enumType.contains(((Enum<?>)object).name())) {
			return new AttValueInfo(object.toString());
		}
		else
			throw new ValueException("expected data type is ENUM, and must in " + enumType + " but not " + object.getClass().getName());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof EnumValue) {
			String v = ((EnumValue)value).getValue();
			return Enum.valueOf((Class<Enum>) type, v);
		}
		else
			throw new ValueException("expected data value is EnumValue, but not " + value.getClass().getName());
	}

	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new EnumValue(a, this);
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		// TODO Auto-generated method stub
		return getData(new EnumValue(value, this), type);
	}

}
