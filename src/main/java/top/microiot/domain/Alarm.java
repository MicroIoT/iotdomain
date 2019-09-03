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
 * 告警类。告警是设备在特定情况下上报的特定信息。
 *
 * @author 曹新宇
 */
@JsonInclude(Include.NON_NULL)
@Document
public class Alarm  implements IoTObject{
	public static final String ALARM_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Id
    private String id;
	@DBRef
	private ManagedObject notifyObject;
	@DBRef
	private Domain domain;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ALARM_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date reportTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ALARM_DATE_FORMAT, locale = "zh", timezone = "GMT+8")
	private Date receiveTime;
	
	private String alarmType;
	private DataValue alarmInfo;
	
	public Alarm() {
		super();
	}
	
	public Alarm(ManagedObject notifyObject, String alarmType, DataValue alarmInfo, Date reportTime) {
		super();
		this.notifyObject = notifyObject;
		this.domain = notifyObject.getDomain();
		this.reportTime = reportTime;
		this.receiveTime = new Date();
		this.alarmType = alarmType;
		this.alarmInfo = alarmInfo;
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
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public DataValue getAlarmInfo() {
		return alarmInfo;
	}
	public void setAlarmInfo(DataValue alarmInfo) {
		this.alarmInfo = alarmInfo;
	} 
}
