package top.microiot.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import top.microiot.domain.attribute.DataType.Type;

import javax.validation.constraints.NotEmpty;

public class ParamInfo {
	@Size (max=20, message="length must be less than 20")
	private String unit;
	@Size (max=255, message="length must be less than 255")
	private String showName;
	@Size (max=255, message="length must be less than 255")
	private String description;
	@NotEmpty(message="parameter name can't be empty")
	@Size (max=255, message="length must be less than 255")
	private String paramName;
	@NotNull(message="data type can't be empty")
	private Type dataType;
	private List<String> dataTypeInfos;
	
	public Type getDataType() {
		return dataType;
	}
	public void setDataType(Type dataType) {
		this.dataType = dataType;
	}
	public List<String> getDataTypeInfos() {
		return dataTypeInfos;
	}
	public void setDataTypeInfos(List<String> dataTypeInfos) {
		this.dataTypeInfos = dataTypeInfos;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
}
