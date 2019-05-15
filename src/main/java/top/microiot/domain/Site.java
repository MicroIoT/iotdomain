package top.microiot.domain;

import java.util.Map;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import top.microiot.domain.attribute.AttributeType;
import top.microiot.domain.attribute.DataValue;

/**
 * 场地类。
 *
 * @author 曹新宇
 */
@CompoundIndex(name = "name_pid_sid_idx", def = "{'name' : 1, 'parent' : 1, 'siteType' : 1}", unique = true)
@Document
public class Site extends NotifyObject {
	private String name;
	@DBRef
	private Site parent;
	@DBRef
	private SiteType siteType;
	private Map<String, DataValue> attributes;
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Site(String name, Site parent, SiteType siteType, Map<String, DataValue> attributes) {
		super();
		this.name = name;
		this.parent = parent;
		this.siteType = siteType;
		this.attributes = attributes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Site getParent() {
		return parent;
	}

	public void setParent(Site parent) {
		this.parent = parent;
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
		Site site = this;
		String origin = "";
		String add;
			
		do {
			add = site.getName() + site.getSiteType().getName();
			add += origin;
			origin = add;
			site = site.parent;
		}while(site != null);
		
		return origin;
	}
	
	public boolean contain(Site b) {
		String asite = this.getString();
		String bsite = b.getString();
		if(asite.length() > bsite.length()) {
			if(asite.contains(bsite))
				return true;
			else
				return false;
		}
		else {
			if(bsite.contains(asite))
				return true;
			else
				return false;
		}	
	}
	
	public boolean containIn(Site b) {
		String asite = this.getString();
		String bsite = b.getString();
		
		if(bsite.contains(asite))
			return true;
		else
			return false;
	}

	@JsonIgnore
	@Override
	public Map<String, AttributeType> getAlarmTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		return NotifyObject.SITE;
	}
}
