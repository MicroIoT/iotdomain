package top.microiot.dto;

import java.util.Map;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.AttValueInfo;

public class EventInfo extends NotificationInfo{
	@NotNull(message = "values can't be null")
	private Map<String, AttValueInfo> values;

	public Map<String, AttValueInfo> getValues() {
		return values;
	}

	public void setValues(Map<String, AttValueInfo> values) {
		this.values = values;
	}

}
