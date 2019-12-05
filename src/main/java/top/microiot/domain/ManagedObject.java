package top.microiot.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import top.microiot.domain.attribute.AttributeType;

/**
 * 系统管理的抽象对象类，被管理对象可以是领域，场地，也可以是设备。
 *
 * @author 曹新宇
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = Device.class, name = ManagedObject.DEVICE), 
	@Type(value = Domain.class, name = ManagedObject.DOMAIN),
	@Type(value = Site.class, name =ManagedObject.SITE) })
public abstract class ManagedObject implements IoTObject {
	public static final String DEVICE = "device";
	public static final String DOMAIN = "domain";
	public static final String SITE = "site";

	@Id
    private String id;
	private String name;
	private String type = this.getClass().getSimpleName().toLowerCase();
	
	public ManagedObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ManagedObject(String name) {
		super();
		this.name = name;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonIgnore
	public abstract Map<String, AttributeType> getAlarmTypes();
	public abstract String getString();
	public abstract String getFullString();
	public boolean contain(ManagedObject mo) {
		String asite = this.getFullString();
		String bsite = mo.getFullString();
		
		if(bsite.startsWith(asite))
			return true;
		else
			return false;
	}
	public boolean contained(ManagedObject mo) {
		String asite = this.getFullString();
		String bsite = mo.getFullString();
		
		if(asite.startsWith(bsite))
			return true;
		else
			return false;
	}
	
	public abstract ManagedObject getLocation();
	public abstract void setLocation(ManagedObject location);
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getFullString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ManagedObject) {
			ManagedObject object = (ManagedObject) obj;
			return object.getId().equals(this.getId());
		}
		return false;
	}
}
