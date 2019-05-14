package top.microiot.dto;

import java.util.Map;

import javax.validation.constraints.NotEmpty;

public class SiteUpdateInfo<T> {
	@NotEmpty(message="site id can't be empty")
	private String id;
	private Map<String, T> attInfos;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, T> getAttInfos() {
		return attInfos;
	}
	public void setAttInfos(Map<String, T> attInfos) {
		this.attInfos = attInfos;
	}
}
