package top.microiot.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = Alarm.class, name = Notification.ALARM), 
	@Type(value = Event.class, name = Notification.EVENT) })
public abstract class Notification {
	public static final String ALARM = "Alarm";
	public static final String EVENT = "Event";
	
	public static final String NOTIFY_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Id
    private String id;
	@DBRef(lazy=true)
	private NotifyObject notifyObject;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = NOTIFY_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date reportTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = NOTIFY_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date receiveTime;
	private String type;
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(NotifyObject notifyObject, Date reportTime) {
		super();
		this.notifyObject = notifyObject;
		this.reportTime = reportTime;
		this.receiveTime = new Date();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public NotifyObject getNotifyObject() {
		return notifyObject;
	}
	public void setNotifyObject(NotifyObject alarmObject) {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
