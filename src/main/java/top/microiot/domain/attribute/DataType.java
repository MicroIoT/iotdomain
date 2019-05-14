package top.microiot.domain.attribute;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import top.microiot.exception.ValueException;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = IntType.class, name = "Int"), 
	@Type(value = DecimalType.class, name = "Decimal"),
	@Type(value = StringType.class, name = "String"), 
	@Type(value = BoolType.class, name = "Bool"),
	@Type(value = EnumType.class, name = "Enum"), 
	@Type(value = DateTimeType.class, name = "DateTime"),
	@Type(value = LocationType.class, name = "Location"), 
	@Type(value = StructType.class, name = "Struct"),
	@Type(value = ArrayType.class, name = "Array"), 
	@Type(value = ChoiceType.class, name = "Choice") })
public abstract class DataType {
	public enum Type {
		Int, Decimal, String, Bool, Enum, DateTime, Location, Struct, Array, Choice, Class;
	}

	private Type type;

	public DataType(Type type) {
		super();
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public abstract boolean isValid(AttValueInfo value);
	public abstract AttValueInfo getAttValue(Object object);
	public abstract DataValue getAttData(Object object);
	public abstract Object getData(DataValue value, Class<?> type);
	public abstract Object getValue(AttValueInfo value, Class<?> type);
	
	public <T> T getData(DataValue value, ParameterizedTypeReference<T> type) {
		throw new ValueException("not support ParameterizedTypeReference type for " + this.getType().toString());
	}

	public <T> T getValue(AttValueInfo value, ParameterizedTypeReference<T> type) {
		throw new ValueException("not support ParameterizedTypeReference type for " + this.getType().toString());
	}
	
	public static DataType getDataType(AttTypeInfo typeInfo) {
		try {
			return DataType.getDataType(typeInfo.getDataType(), typeInfo.getDataTypeInfos(), typeInfo.getAdditional());
		} catch (ValueException e) {
			throw new ValueException(typeInfo.getName() + ": " + e.getMessage());
		}
	}
	public static DataType getDataType(Type dataType, Map<String, String> dataTypeInfos, List<? extends AttTypeInfo> additional) {
		switch (dataType) {
		case DateTime:
			return new DateTimeType(dataTypeInfos);
		case Enum:
			return new EnumType(dataTypeInfos);
		case String:
			return new StringType(dataTypeInfos);
		case Int:
			return new IntType();
		case Decimal:
			return new DecimalType();
		case Bool:
			return new BoolType();
		case Location:
			return new LocationType();
		case Struct:
			return new StructType(additional);
		case Array:
			return new ArrayType(dataTypeInfos, additional);
		case Choice:
			return new ChoiceType(additional);
		default:
			throw new ValueException("invalid data type");
		}
	}
}
