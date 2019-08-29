package top.microiot.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 通知抽象类，是告警和事件的父类。
 *
 * @author 曹新宇
 */
public abstract class Notification {
	public static final String NOTIFY_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Id
    private String id;
	@DBRef(lazy=true)
	private ManagedObject notifyObject;
	@DBRef
	private Domain domain;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = NOTIFY_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date reportTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = NOTIFY_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date receiveTime;
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(ManagedObject notifyObject, Date reportTime) {
		super();
		this.notifyObject = notifyObject;
		this.domain = notifyObject.getDomain();
		this.reportTime = reportTime;
		this.receiveTime = new Date();
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
}
