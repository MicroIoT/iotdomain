package top.microiot.dto;

import java.util.List;

import javax.validation.Valid;

import top.microiot.domain.attribute.AttTypeInfo;
import top.microiot.domain.attribute.ClassTypeDeviceInfo;

/**
 * 设备类型输入信息类。
 *
 * @author 曹新宇
 */
public class DeviceTypeInfo extends AttTypeInfo {
	public DeviceTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceTypeInfo(ClassTypeDeviceInfo info, List<? extends AttTypeInfo> staticAttTypeInfo, List<? extends AttTypeInfo> alarmTypeInfos, List<ActionTypeInfo> actionTypeInfos, Boolean isGroup) {
		super(info.getName(), info.getDataType(), info.getDescription(), false, null, info.getAdditional());
		this.staticAttTypeInfo = staticAttTypeInfo;
		this.alarmTypeInfos = alarmTypeInfos;
		this.actionTypeInfos = actionTypeInfos;
		this.isGroup = isGroup;
	}
	public DeviceTypeInfo(ClassTypeDeviceInfo info, List<? extends AttTypeInfo> staticAttTypeInfo, List<? extends AttTypeInfo> alarmTypeInfos, List<ActionTypeInfo> actionTypeInfos) {
		super(info.getName(), info.getDataType(), info.getDescription(), false, null, info.getAdditional());
		this.staticAttTypeInfo = staticAttTypeInfo;
		this.alarmTypeInfos = alarmTypeInfos;
		this.actionTypeInfos = actionTypeInfos;
		this.isGroup = false;
	}
	@Valid
	private List<? extends AttTypeInfo> staticAttTypeInfo;
	@Valid
	private List<? extends AttTypeInfo> alarmTypeInfos;
	@Valid
	private List<ActionTypeInfo> actionTypeInfos;
	private boolean isGroup;
	
	public List<? extends AttTypeInfo> getAlarmTypeInfos() {
		return alarmTypeInfos;
	}
	public void setAlarmTypeInfos(List<? extends AttTypeInfo> alarmTypeInfos) {
		this.alarmTypeInfos = alarmTypeInfos;
	}
	public List<ActionTypeInfo> getActionTypeInfos() {
		return actionTypeInfos;
	}
	public void setActionTypeInfos(List<ActionTypeInfo> actionTypeInfos) {
		this.actionTypeInfos = actionTypeInfos;
	}
	public List<? extends AttTypeInfo> getStaticAttTypeInfo() {
		return staticAttTypeInfo;
	}
	public void setStaticAttTypeInfo(List<? extends AttTypeInfo> staticAttTypeInfo) {
		this.staticAttTypeInfo = staticAttTypeInfo;
	}
	public boolean isGroup() {
		return isGroup;
	}
	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}
}
