package top.microiot.dto;

import javax.validation.constraints.NotEmpty;

import top.microiot.domain.attribute.AttTypeInfo;
import top.microiot.domain.attribute.ClassTypeInfo;

public class SiteTypeInfo extends AttTypeInfo {
	@NotEmpty(message="domain id can't be empty")
	private String domainId;

	public SiteTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SiteTypeInfo(String domainId, ClassTypeInfo info) {
		super(info.getName(), info.getDataType(), info.getDescription(), info.isOptional(), info.getDataTypeInfos(), info.getAdditional());
		this.domainId = domainId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
}
