package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class FormatInfo {
	@NotEmpty(message="value can't be empty")
	private String value;
	@NotEmpty(message="form can't be empty")
	private String format;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
