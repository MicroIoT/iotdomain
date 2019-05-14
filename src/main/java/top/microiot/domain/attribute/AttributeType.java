package top.microiot.domain.attribute;

import org.springframework.core.ParameterizedTypeReference;

import top.microiot.exception.ValueException;

public class AttributeType {
	private DataType dataType;
	private boolean optional;
	private String description;
	
	public AttributeType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttributeType(AttTypeInfo type) {
		super();
		this.dataType = DataType.getDataType(type);
		this.optional = type.isOptional();
		this.description = type.getDescription();
	}
	
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public boolean isOptional() {
		return optional;
	}
	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AttValueInfo getAttValue(Object object) {
		if(object == null && isOptional() )
			return null;
		else if(object == null && !isOptional())
			throw new ValueException(" can't be null.");
		else
			return dataType.getAttValue(object);
	}
	public DataValue getAttData(Object object) {
		if(object == null && isOptional() )
			return null;
		else if(object == null && !isOptional())
			throw new ValueException(" can't be null.");
		else
			return dataType.getAttData(object);
	}
	public Object getData(DataValue value, Class<?> type) {
		if(value == null && isOptional())
			return null;
		else if(value == null && !isOptional())
			throw new ValueException(" can't be null.");
		else
			return dataType.getData(value, type);
	}
	public Object getValue(AttValueInfo value, Class<?> type) {
		if(value == null && isOptional())
			return null;
		else if(value == null && !isOptional())
			throw new ValueException(" can't be null.");
		else
			return dataType.getValue(value, type);
	}
	public <T> Object getData(DataValue value, ParameterizedTypeReference<T> type) {
		if(value == null && isOptional())
			return null;
		else if(value == null && !isOptional())
			throw new ValueException(" can't be null.");
		else
			return dataType.getData(value, type);
	}
	public <T> Object getValue(AttValueInfo value, ParameterizedTypeReference<T> type) {
		if(value == null && isOptional())
			return null;
		else if(value == null && !isOptional())
			throw new ValueException(" can't be null.");
		else
			return dataType.getValue(value, type);
	}
}
