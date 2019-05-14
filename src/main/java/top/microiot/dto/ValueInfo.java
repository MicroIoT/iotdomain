package top.microiot.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

public class ValueInfo {
	@NotEmpty(message="parameter can't be empty")
	private String parameter;
	@NotNull(message="value can't be empty")
	private Double value; 
	
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
}
