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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = Device.class, name = "DEVICE"), 
	@Type(value = Domain.class, name = "DOMAIN"),
	@Type(value = Site.class, name ="SITE") })
public abstract class ManagedObject {
	public static enum Type {
		DOMAIN, SITE, DEVICE;
	}

	@Id
    private String id;
	private Type type;
	
	public ManagedObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ManagedObject(Type type) {
		super();
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@JsonIgnore
	public abstract Map<String, AttributeType> getAlarmTypes();
	public abstract String getString();
	public abstract String getFullString();
	public abstract String getName();
	public abstract void setName(String name);
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
	public abstract Domain getDomain();
}
