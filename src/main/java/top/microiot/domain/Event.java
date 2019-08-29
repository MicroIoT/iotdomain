package top.microiot.domain;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import top.microiot.domain.attribute.DataValue;

/**
 * 事件类。事件是设备主动上报的属性值。
 *
 * @author 曹新宇
 */
@JsonInclude(Include.NON_NULL)
@Document
@TypeAlias("event")
public class Event extends Notification{
	private String attribute;
	private DataValue value; 
	
	public Event() {
		super();
	}

	public Event(ManagedObject notifyObject, String attribute, DataValue value, Date reportTime) {
		super(notifyObject, reportTime);
		this.attribute = attribute;
		this.value = value;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public DataValue getValue() {
		return value;
	}

	public void setValue(DataValue value) {
		this.value = value;
	}
}
