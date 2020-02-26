package top.microiot.domain;

import java.util.Map;

import top.microiot.domain.attribute.AttributeType;
import top.microiot.domain.attribute.DeviceAttributeType;

public class DeviceTypeFile {
    private String name;
	private String description;

	private Map<String, DeviceAttributeType> attDefinition;
	private Map<String, AttributeType> staticAttDefinition;
	private Map<String, AttributeType> alarmTypes;
	private Map<String, ActionType> actionTypes;
	
	public DeviceTypeFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceTypeFile(DeviceType deviceType) {
		this.name = deviceType.getName();
		this.description = deviceType.getDescription();
		
		this.attDefinition = deviceType.getAttDefinition();
		this.staticAttDefinition = deviceType.getStaticAttDefinition();
		this.alarmTypes = deviceType.getAlarmTypes();
		this.actionTypes = deviceType.getActionTypes();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, DeviceAttributeType> getAttDefinition() {
		return attDefinition;
	}

	public void setAttDefinition(Map<String, DeviceAttributeType> attDefinition) {
		this.attDefinition = attDefinition;
	}

	public Map<String, AttributeType> getStaticAttDefinition() {
		return staticAttDefinition;
	}

	public void setStaticAttDefinition(Map<String, AttributeType> staticAttDefinition) {
		this.staticAttDefinition = staticAttDefinition;
	}

	public Map<String, AttributeType> getAlarmTypes() {
		return alarmTypes;
	}

	public void setAlarmTypes(Map<String, AttributeType> alarmTypes) {
		this.alarmTypes = alarmTypes;
	}

	public Map<String, ActionType> getActionTypes() {
		return actionTypes;
	}

	public void setActionTypes(Map<String, ActionType> actionTypes) {
		this.actionTypes = actionTypes;
	}
}
