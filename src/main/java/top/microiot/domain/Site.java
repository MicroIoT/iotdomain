package top.microiot.domain;

import java.util.Map;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import top.microiot.domain.attribute.AttributeType;
import top.microiot.domain.attribute.DataValue;
import top.microiot.exception.ValueException;

/**
 * 场地类。
 *
 * @author 曹新宇
 */
@CompoundIndex(name = "name_loc_type_idx", def = "{'name' : 1, 'location' : 1, 'siteType' : 1}", unique = true)
@Document
@TypeAlias("site")
public class Site extends ManagedObject {
	private String name;
	@DBRef
	private ManagedObject location;
	@DBRef
	private SiteType siteType;
	private Map<String, DataValue> attributes;
	@DBRef
	private Domain domain;
	
	public Site() {
		super();
		this.setType(Type.SITE);
	}

	public Site(String name, ManagedObject location, SiteType siteType, Map<String, DataValue> attributes) {
		super(Type.SITE);
		this.name = name;
		if(location instanceof Device)
			throw new ValueException("illegal location type");
		this.location = location;
		this.siteType = siteType;
		this.attributes = attributes;
		this.domain = siteType.getDomain();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ManagedObject getLocation() {
		return location;
	}

	public void setLocation(ManagedObject location) {
		this.location = location;
	}

	public SiteType getSiteType() {
		return siteType;
	}

	public void setSiteType(SiteType siteType) {
		this.siteType = siteType;
	}

	public Map<String, DataValue> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, DataValue> attributes) {
		this.attributes = attributes;
	}
	
	public String getString() {
		ManagedObject area = this;
		String origin = "";
		String add;
			
		while( !(area instanceof Domain)) {
			Site site = (Site) area;
			add = site.getName() + site.getSiteType().getName();
			add += origin;
			origin = add;
			area = site.location;
		}
		
		return origin;
	}
	
	public String getFullString() {
		ManagedObject area = this;
		String origin = "";
		String add;
			
		while( !(area instanceof Domain)) {
			Site site = (Site) area;
			add = site.getName() + site.getSiteType().getName();
			add += origin;
			origin = add;
			area = site.location;
		}
		
		Domain s = (Domain) area;
		return s.getName() + origin;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@JsonIgnore
	@Override
	public Map<String, AttributeType> getAlarmTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}
