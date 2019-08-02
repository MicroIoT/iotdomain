package top.microiot.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import top.microiot.domain.attribute.AttributeType;
import top.microiot.domain.attribute.DeviceAttributeType;

/**
 * 设备类型类。
 *
 * @author 曹新宇
 */
@CompoundIndex(name = "name_idx", def = "{'name' : 1}", unique = true)
@Document
public class DeviceType {
	@Id
    private String id;
	private String name;
	private String description;
	private Map<String, DeviceAttributeType> attDefinition;
	private Map<String, AttributeType> staticAttDefinition;
	private Map<String, AttributeType> alarmTypes;
	private Map<String, ActionType> actionTypes;
	private boolean isGroup;
	
	public DeviceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceType(String name, String description, Map<String,DeviceAttributeType> attDefinition, Map<String, AttributeType> staticAttDefinition, Map<String, AttributeType> alarmTypes, Map<String, ActionType> actionTypes ) {
		super();
		this.name = name;
		this.description = description;
		this.attDefinition = attDefinition;
		this.staticAttDefinition = staticAttDefinition;
		this.alarmTypes = alarmTypes;
		this.actionTypes = actionTypes;
		this.isGroup = false;
	}

	public DeviceType(String name, String description, Map<String, DeviceAttributeType> attDefinition, 	Map<String, AttributeType> staticAttDefinition, Map<String, AttributeType> alarmTypes, Map<String, ActionType> actionTypes, boolean isGroup) {
		super();
		this.name = name;
		this.description = description;
		this.attDefinition = attDefinition;
		this.staticAttDefinition = staticAttDefinition;
		this.alarmTypes = alarmTypes;
		this.actionTypes = actionTypes;
		this.isGroup = isGroup;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String typeName) {
		this.name = typeName;
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

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}
}
