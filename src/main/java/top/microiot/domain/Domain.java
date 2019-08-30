package top.microiot.domain;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import top.microiot.domain.attribute.AttributeType;

/**
 * 领域类。领域是一组相关的场地类型，设备类型，场地和设备的集合。
 *
 * @author 曹新宇
 */
@JsonInclude(Include.NON_NULL)
@Document
@TypeAlias("domain")
public class Domain extends ManagedObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3158030198625660034L;
	@Indexed(unique=true)
	private String name;
	
	public Domain() {
		super();
		this.setType(Type.DOMAIN);
	}

	public Domain(String name) {
		super(Type.DOMAIN);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getString() {
		return getName();
	}
	
	@Override
	public String getFullString() {
		return getName();
	}

	@Override
	public Map<String, AttributeType> getAlarmTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedObject getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocation(ManagedObject location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@JsonIgnore
	public Domain getDomain() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Domain) {
			Domain domain = (Domain) obj;
			return domain.getId().equals(this.getId());
		}
		return false;
	}
}
