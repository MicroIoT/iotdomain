package top.microiot.domain.attribute;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonTypeName;

import top.microiot.exception.NotFoundException;
import top.microiot.exception.ValueException;

@JsonTypeName(DataType.STRUCT)
public class StructType extends DataType{
	private Map<String, AttributeType> attTypes;
	
	public StructType() {
		super(Type.Struct);
		// TODO Auto-generated constructor stub
	}

	public StructType(Map<String, AttributeType> attTypes) {
		super(Type.Struct);
		this.attTypes = attTypes;
	}

	public StructType(List<? extends AttTypeInfo> additional) {
		super(Type.Struct);
		if(additional == null)
			throw new ValueException("no struct definition");
		AttributeTypes attributes = new AttributeTypes(additional);
		attTypes = attributes.getAttTypes();
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getStructValue() == null)
			return false;
		return true;
	}

	public Map<String, AttributeType> getAttTypes() {
		return attTypes;
	}

	public void setAttTypes(Map<String, AttributeType> attTypes) {
		this.attTypes = attTypes;
	}

	@Override
	public AttValueInfo getAttValue(Object object) {
		Map<String, AttValueInfo> structValue = new HashMap<String, AttValueInfo>();
		Class<?> clazz = object.getClass();
		List<Field> fields = getAllFields(new LinkedList<Field>(), clazz);
		if(attTypes != null) {
			for (String key : attTypes.keySet()) {
				AttributeType attType = attTypes.get(key);
				
				Field field = getField(key, fields);
				
				if(!attType.isOptional() && field == null)
					throw new NotFoundException("attribute [" + key + "]");
				else if(field != null) {
					Object value;
					field.setAccessible(true);
					try {
						value = field.get(object);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						value = null;
					}
					if(value == null && attType.isOptional())
						;
					else if(value == null && !attType.isOptional())
						throw new NotFoundException("attribute [" + key + "]");
					else {
						try{
							AttValueInfo a =attType.getAttValue(value);
							structValue.put(key, a);
						}
						catch(ValueException e) {
							throw new  ValueException("attribute [" + key + "] value error: " + e.getMessage());
						}
					}
				}
			}
		}
		return new AttValueInfo(structValue);
	}
	
	private Field getField(String name, List<Field> fields) {
		for(Field field : fields) {
			if(field.getName().equals(name))
				return field;
		}
		return null;
	}
	
	private List<Field> getAllFields(List<Field> fields, Class<?> type) {
	    fields.addAll(Arrays.asList(type.getDeclaredFields()));

	    if (type.getSuperclass() != null) {
	        getAllFields(fields, type.getSuperclass());
	    }

	    return fields;
	}

	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof StructValue) {
			List<Field> fields = getAllFields(new LinkedList<Field>(), type);
			
			try {
				Object struct = Class.forName(type.getName()).newInstance();
				for (String key : attTypes.keySet()) {
					AttributeType attType = attTypes.get(key);
					DataValue dataValue = ((StructValue) value).getValue().get(key);
					Field field = getField(key, fields);
					if(attType.isOptional()) {
						if(field != null && dataValue != null) {
							copyValueToField(struct, attType, dataValue, field);
						}
					} else {
						if(field == null)
							throw new NotFoundException("attribute [" + key + "] in " + type.getName());
						else if(dataValue == null)
							throw new NotFoundException("attribute [" + key + "] in source");
						else {
							copyValueToField(struct, attType, dataValue, field);
						}
					}
				}
				return struct;
			} catch (InstantiationException e) {
				throw new ValueException("class instantiation error: must be parameterless constructor " + e.getMessage());
			} catch (IllegalAccessException | ClassNotFoundException e) {
				throw new ValueException("class error: " + e.getMessage());
			}
		} else
			throw new ValueException("expected data value is StructValue, but not " + value.getClass().getName());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void copyValueToField(Object struct, AttributeType attType, DataValue dataValue, Field field)
			throws IllegalAccessException {
		Class<?> type = field.getType();
		if(dataValue instanceof ArrayValue) {
			ParameterizedType pType = (ParameterizedType)field.getGenericType();
			type = (Class<?>) pType.getActualTypeArguments()[0];
		}
		Object v = attType.getData(dataValue, type);	
		field.setAccessible(true);
		if(dataValue instanceof ArrayValue) {
			if(List.class.isAssignableFrom(field.getType()))
				field.set(struct, v);
			else if(Set.class.isAssignableFrom(field.getType())) {
				field.set(struct , new HashSet((Collection) v));
			}
			else if(field.getType().isArray()) {
				field.set(struct, ((List)v).toArray());
			}
			else
				throw new ValueException(field.getName() + " must be List, Set or Array");
		}
		else
			field.set(struct, v);
	}

	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new StructValue(a, this);
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		// TODO Auto-generated method stub
		return getData(new StructValue(value, this), type);
	}
}
