package top.microiot.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import top.microiot.domain.attribute.AttTypeInfo;

public class ActionTypeInfo {
	@NotEmpty(message="action type name can't be empty")
	private String name;
	private String description;
	@Valid
	private AttTypeInfo requestInfo;
	@Valid
	private AttTypeInfo responseInfo;
	
	public ActionTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ActionTypeInfo(@NotEmpty(message = "action type name can't be empty") String name, String description,
			@Valid AttTypeInfo requestInfo, @Valid AttTypeInfo responseInfo) {
		super();
		this.name = name;
		this.description = description;
		this.requestInfo = requestInfo;
		this.responseInfo = responseInfo;
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
	public AttTypeInfo getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(AttTypeInfo requestInfo) {
		this.requestInfo = requestInfo;
	}
	public AttTypeInfo getResponseInfo() {
		return responseInfo;
	}
	public void setResponseInfo(AttTypeInfo responseInfo) {
		this.responseInfo = responseInfo;
	}
	
	
}
