package top.microiot.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Event implements IoTObject{
	public static final String EVENT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Id
    private String id;
	@DBRef
	private ManagedObject notifyObject;
	@DBRef
	private Domain domain;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = EVENT_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date reportTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = EVENT_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date receiveTime;
	
	private String attribute;
	private DataValue value; 
	
	public Event() {
		super();
	}

	public Event(ManagedObject notifyObject, String attribute, DataValue value, Date reportTime) {
		super();
		this.notifyObject = notifyObject;
		this.domain = notifyObject.getDomain();
		this.reportTime = reportTime;
		this.receiveTime = new Date();
		this.attribute = attribute;
		this.value = value;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ManagedObject getNotifyObject() {
		return notifyObject;
	}
	public void setNotifyObject(ManagedObject alarmObject) {
		this.notifyObject = alarmObject;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
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
