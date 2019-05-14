package top.microiot.domain.attribute;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = IntValue.class, name = "Int"), 
	@Type(value = DecimalValue.class, name = "Decimal"),
	@Type(value = StringValue.class, name = "String"), 
	@Type(value = BoolValue.class, name = "Bool"),
	@Type(value = EnumValue.class, name = "Enum"), 
	@Type(value = DateTimeValue.class, name = "DateTime"),
	@Type(value = LocationValue.class, name = "Location"), 
	@Type(value = StructValue.class, name = "Struct"),
	@Type(value = ArrayValue.class, name = "Array"), 
	@Type(value = ChoiceValue.class, name = "Choice") })
public abstract class DataValue {
	public abstract String getString();
	public static DataValue getDataValue(AttValueInfo value, DataType type){
		top.microiot.domain.attribute.DataType.Type t = type.getType();
		switch(t){
		case DateTime:
			return new DateTimeValue(value, (DateTimeType) type);
		case Enum:
			return new EnumValue(value, (EnumType) type);
		case String:
			return new StringValue(value, (StringType) type);
		case Int:
			return new IntValue(value.getValue());
		case Decimal:
			return new DecimalValue(value.getValue());
		case Bool:
			return new BoolValue(value.getValue());
		case Location:
			return new LocationValue(value.getValue());
		case Struct:
			return new StructValue(value, (StructType)type);
		case Array:
			return new ArrayValue(value, (ArrayType)type);
		case Choice:
			return new ChoiceValue(value, (ChoiceType)type);
		default:
			throw new RuntimeException("invalid data type");
		}
	}
}
