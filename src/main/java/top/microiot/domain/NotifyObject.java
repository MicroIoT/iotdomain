package top.microiot.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import top.microiot.domain.attribute.AttributeType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = Site.class, name = NotifyObject.SITE), 
	@Type(value = Device.class, name =NotifyObject. DEVICE) })
public abstract class NotifyObject {
	public static final String SITE = "site";
	public static final String DEVICE = "device";
	@Id
    private String id;
	
	public NotifyObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public abstract Map<String, AttributeType> getAlarmTypes();
	public abstract String getString();
	public abstract String getType();
}
