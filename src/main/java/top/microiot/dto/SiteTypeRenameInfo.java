package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class SiteTypeRenameInfo {
	@NotEmpty(message="site type id can't be empty")
	private String id;
	@NotEmpty(message="name can't be empty")
	private String name;
	private String description;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
