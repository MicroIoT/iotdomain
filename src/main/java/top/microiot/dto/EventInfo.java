package top.microiot.dto;

import java.util.Map;

import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.AttValueInfo;

/**
 * 事件输入信息类。
 *
 * @author 曹新宇
 */
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
