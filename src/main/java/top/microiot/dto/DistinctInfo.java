package top.microiot.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import top.microiot.domain.IoTObject;

public class DistinctInfo extends QueryPageInfo{
	@NotEmpty(message="field can't be empty")
	private String field;
	@NotNull(message="return class can't be null")
	private String returnClass;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getReturnClass() {
		return returnClass;
	}
	public void setReturnClass(String className) {
		this.returnClass = className;
	}
	public void setReturnClass(Class<? extends IoTObject> object) {
		this.returnClass = object.getSimpleName().toLowerCase() + "s";
	}
}
