package top.microiot.domain.attribute;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = IntValue.class, name = DataType.INT), 
	@Type(value = DecimalValue.class, name = DataType.DECIMAL),
	@Type(value = StringValue.class, name = DataType.STRING), 
	@Type(value = BoolValue.class, name = DataType.BOOL),
	@Type(value = EnumValue.class, name = DataType.ENUM), 
	@Type(value = DateTimeValue.class, name = DataType.DATE),
	@Type(value = LocationValue.class, name = DataType.LOCATION), 
	@Type(value = StructValue.class, name = DataType.STRUCT),
	@Type(value = ArrayValue.class, name = DataType.ARRAY), 
	@Type(value = ChoiceValue.class, name = DataType.CHOICE) })
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
