package top.microiot.domain.attribute;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;

import top.microiot.exception.ValueException;

public class ArrayType extends DataType {
	public static final String TYPE = "array.type";
	private DataType dataType;

	public ArrayType() {
		super(Type.Array);
		// TODO Auto-generated constructor stub
	}

	public ArrayType(Map<String, String> dataTypeInfos, List<? extends AttTypeInfo> additional) {
		super(Type.Array);
		Type type = Type.valueOf(dataTypeInfos.get(TYPE));
		if (type == null)
			throw new ValueException("no definition of type");
		this.dataType = DataType.getDataType(type, dataTypeInfos, additional);
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if (value.getArrayValue() == null)
			return false;
		return true;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public AttValueInfo getAttValue(Object object) {
		if (object instanceof List) {
			return getListValue((List) object);
		} else if (object instanceof Set) {
			List valueList = new ArrayList();
			valueList.addAll((Set) object);
			return getListValue(valueList);
		} else if (object.getClass().isArray()) {
			return getListValue(Arrays.asList(object));
		} else
			throw new ValueException("expected data type is List, Set or Array, but not " + object.getClass().getName());
	}

	private AttValueInfo getListValue(@SuppressWarnings("rawtypes") List valueList) {
		List<AttValueInfo> result = new ArrayList<AttValueInfo>();
		AttValueInfo a = null;
		for (Object value : valueList) {
			a = dataType.getAttValue(value);
			result.add(a);
		}
		return new AttValueInfo(result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getData(DataValue value, Class<?> type) {
		if (value instanceof ArrayValue) {
			List list = new ArrayList();

			for (DataValue dataValue : ((ArrayValue) value).getValue()) {
				Object o = dataType.getData(dataValue, type);
				list.add(o);
			}
			return list;
		} else
			throw new ValueException("expected data value is ArrayValue, but not " + value.getClass().getName());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> T getData(DataValue value, ParameterizedTypeReference<T> type) {
		if (value instanceof ArrayValue) {
			ParameterizedType t = (ParameterizedType) type.getType();
			java.lang.reflect.Type rawType = t.getRawType();
			java.lang.reflect.Type subType = t.getActualTypeArguments()[0];
			Class<?> clazz = (Class<?>)subType;
			
			List list;
			Set set;
			if(rawType == List.class) {
				list = new ArrayList();
				
				for (DataValue dataValue : ((ArrayValue) value).getValue()) {
					Object o = dataType.getData(dataValue, clazz);
					list.add(o);
				}
				return (T) list;
			}
			else if(rawType == Set.class) {
				set = new HashSet();
				
				for (DataValue dataValue : ((ArrayValue) value).getValue()) {
					Object o = dataType.getData(dataValue, clazz);
					set.add(o);
				}
				return (T) set;
			}
			else
				throw new ValueException("only support List and Set for Array ");
			
		} else
			throw new ValueException("expected data value is ArrayValue, but not " + value.getClass().getName());
	}
	
	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);

		return new ArrayValue(a, this);
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		// TODO Auto-generated method stub
		return getData(new ArrayValue(value, this), type);
	}

	@Override
	public <T> T getValue(AttValueInfo value, ParameterizedTypeReference<T> type) {
		// TODO Auto-generated method stub
		return getData(new ArrayValue(value, this), type);
	}

	
}
