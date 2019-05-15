package top.microiot.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import top.microiot.domain.attribute.AttributeType;

/**
 * 场地类型类。
 *
 * @author 曹新宇
 */
@CompoundIndex(name = "name_idx", def = "{'name' : 1}", unique = true)
@Document
public class SiteType {
	@Id
	private String id;
	private String name;
	private String description;
	private Map<String, AttributeType> attDefinition;
	
	public SiteType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SiteType(String name, String description, Map<String, AttributeType> attDefinition) {
		super();
		this.name = name;
		this.description = description;
		this.attDefinition = attDefinition;
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
	public Map<String, AttributeType> getAttDefinition() {
		return attDefinition;
	}
	public void setAttDefinition(Map<String, AttributeType> attDefinition) {
		this.attDefinition = attDefinition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
