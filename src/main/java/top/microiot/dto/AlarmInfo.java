package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

import top.microiot.domain.attribute.AttValueInfo;

/**
 * 告警输入信息类。
 *
 * @author 曹新宇
 */
public class AlarmInfo extends NotificationInfo {
	@NotEmpty(message="alarm type can't be empty")
	private String alarmType;
	private AttValueInfo alarmInfo;
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public AttValueInfo getAlarmInfo() {
		return alarmInfo;
	}
	public void setAlarmInfo(AttValueInfo alarmInfo) {
		this.alarmInfo = alarmInfo;
	}
}
