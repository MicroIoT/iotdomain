package top.microiot.domain;

import java.util.Map;

import top.microiot.domain.attribute.AttributeType;

public class SiteTypeFile {
	private String name;
	private String description;
	
	private Map<String, AttributeType> attDefinition;

	public SiteTypeFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SiteTypeFile(SiteType siteType) {
		this.name = siteType.getName();
		this.description = siteType.getDescription();
		
		this.attDefinition = siteType.getAttDefinition();
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

	public Map<String, AttributeType> getAttDefinition() {
		return attDefinition;
	}

	public void setAttDefinition(Map<String, AttributeType> attDefinition) {
		this.attDefinition = attDefinition;
	}
}
