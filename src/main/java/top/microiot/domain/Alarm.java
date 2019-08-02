package top.microiot.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

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
public class Alarm  extends Notification{
	private String alarmType;
	private DataValue alarmInfo;
	public Alarm() {
		super();
		this.setType(Notification.ALARM);
	}
	public Alarm(NotifyObject notifyObject, String alarmType, DataValue alarmInfo, Date reportTime) {
		super(notifyObject, reportTime);
		this.alarmType = alarmType;
		this.alarmInfo = alarmInfo;
		this.setType(Notification.ALARM);
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
