package top.microiot.domain.attribute;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AttValueInfo {
	private String value;
	private List<AttValueInfo> arrayValue;
	private Map<String, AttValueInfo> structValue;
	
	public AttValueInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttValueInfo(String value) {
		super();
		this.value = value;
	}
	public AttValueInfo(List<AttValueInfo> arrayValue) {
		super();
		this.arrayValue = arrayValue;
	}
	public AttValueInfo(Map<String, AttValueInfo> structValue) {
		super();
		this.structValue = structValue;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<AttValueInfo> getArrayValue() {
		return arrayValue;
	}
	public void setArrayValue(List<AttValueInfo> arrayValue) {
		this.arrayValue = arrayValue;
	}
	public Map<String, AttValueInfo> getStructValue() {
		return structValue;
	}
	public void setStructValue(Map<String, AttValueInfo> structValue) {
		this.structValue = structValue;
	}
	@JsonIgnore
	public boolean isEmpty() {
		return (value == null || value.length() == 0) 
				&& (arrayValue == null || arrayValue.size() == 0) 
				&& (structValue == null || structValue.size() == 0);
	}
}
