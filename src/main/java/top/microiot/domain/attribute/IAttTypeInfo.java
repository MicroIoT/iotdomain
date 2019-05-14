package top.microiot.domain.attribute;

import java.util.List;
import java.util.Map;

import top.microiot.domain.attribute.DataType.Type;

public interface IAttTypeInfo {

	String getName();

	void setName(String name);

	Type getDataType();

	void setDataType(Type dataType);

	boolean isOptional();

	void setOptional(boolean optional);

	Map<String, String> getDataTypeInfos();

	void setDataTypeInfos(Map<String, String> dataTypeInfos);

	String getDescription();

	void setDescription(String description);

	List<? extends AttTypeInfo> getAdditional();

	void setAdditional(List<? extends AttTypeInfo> additional);

}