package top.microiot.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import top.microiot.domain.attribute.AttributeType;

/**
 * 设备的操作类型。
 *
 * @author 曹新宇
 */
public class ActionType {
	private Map<String, AttributeType> request = null;
	private Map<String, AttributeType> response = null;
	private String description;
	
	public ActionType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActionType(String requestName, AttributeType request, String responseName, AttributeType response, String description) {
		super();
		if(requestName != null && request != null) {
			this.request = new HashMap<String, AttributeType>();
			this.request.put(requestName, request);
		}
		if(responseName != null && response != null) {
			this.response = new HashMap<String, AttributeType>();
			this.response.put(responseName, response);
		}
		this.description = description;
	}

	public Map<String, AttributeType> getRequest() {
		return request;
	}

	@JsonIgnore
	public AttributeType getRequestAttributeType() {
		if(request != null) {
			for (Map.Entry<String, AttributeType> entry : request.entrySet()) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	@JsonIgnore
	public AttributeType getResponseAttributeType() {
		if(response != null) {
			for (Map.Entry<String, AttributeType> entry : response.entrySet()) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	public void setRequest(Map<String, AttributeType> request) {
		this.request = request;
	}

	public Map<String, AttributeType> getResponse() {
		return response;
	}

	public void setResponse(Map<String, AttributeType> response) {
		this.response = response;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
