package top.microiot.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

/**
 * 修改用户输入信息类。
 *
 * @author 曹新宇
 */
public class UserUpdateInfo {
	@NotEmpty(message="userId can't be empty")
	private String userId;
	private List<String> area;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getArea() {
		return area;
	}
	public void setArea(List<String> area) {
		this.area = area;
	}
}
