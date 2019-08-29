package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

public class DomainInfo {
	@NotEmpty(message="domain name can't be empty")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
