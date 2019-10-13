package top.microiot.dto;

/**
 * 告警查询条件类。
 *
 * @author 曹新宇
 */
public class ConfigListInfo {
	private Boolean top;
	private Boolean silent;
	private Boolean subscribe;
	
	public Boolean getTop() {
		return top;
	}
	public void setTop(Boolean top) {
		this.top = top;
	}
	public Boolean getSilent() {
		return silent;
	}
	public void setSilent(Boolean silent) {
		this.silent = silent;
	}
	public Boolean getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Boolean subscribe) {
		this.subscribe = subscribe;
	}
}
