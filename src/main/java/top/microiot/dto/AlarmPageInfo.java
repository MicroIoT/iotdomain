package top.microiot.dto;

public class AlarmPageInfo extends NotificationPageInfo {
	private String notifyObjectId;
	private String alarmType;
	
	public String getNotifyObjectId() {
		return notifyObjectId;
	}
	public void setNotifyObjectId(String notifyObjectId) {
		this.notifyObjectId = notifyObjectId;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
}
