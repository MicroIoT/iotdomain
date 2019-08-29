package top.microiot.domain;

/**
 * 系统预定义的设备告警类型。
 *
 * @author 曹新宇
 */
public class AlarmType {
	public static final String DISCONNECTED = "失去长连接";
	public static final String CONNECTED = "建立长连接";
	public static final String ATTRIBUTE_CHANGED_ALARM = "AttributeChangedAlarm";
}
