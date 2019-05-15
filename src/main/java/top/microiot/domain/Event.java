package top.microiot.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import top.microiot.domain.attribute.DataValue;

/**
 * 事件类。
 *
 * @author 曹新宇
 */
@JsonInclude(Include.NON_NULL)
@Document
public class Event extends Notification{
	private String attribute;
	private DataValue value; 
	
	public Event() {
		super();
		this.setType(Notification.EVENT);
	}

	public Event(NotifyObject notifyObject, String attribute, DataValue value, Date reportTime) {
		super(notifyObject, reportTime);
		this.attribute = attribute;
		this.value = value;
		this.setType(Notification.EVENT);
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
