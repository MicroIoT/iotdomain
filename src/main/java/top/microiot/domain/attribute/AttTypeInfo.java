package top.microiot.domain.attribute;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import top.microiot.domain.attribute.DataType.Type;

public class AttTypeInfo implements IAttTypeInfo {
	private String name;
	@NotNull(message="data type can't be empty")
	private Type dataType;
	private String description;
	@NotNull(message="optional can't be empty")
	private Boolean optional;
	private Map<String, String> dataTypeInfos;
	@Valid
	private List<? extends AttTypeInfo> additional;
	
	
	public AttTypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttTypeInfo(String name, @NotNull(message = "data type can't be empty") Type dataType, String description,
			@NotNull(message = "optional can't be empty") Boolean optional, Map<String, String> dataTypeInfos,
			@Valid List<? extends AttTypeInfo> additional) {
		super();
		this.name = name;
		this.dataType = dataType;
		this.description = description;
		this.optional = optional;
		this.dataTypeInfos = dataTypeInfos;
		this.additional = additional;
	}
	
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#getDataType()
	 */
	@Override
	public Type getDataType() {
		return dataType;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#setDataType(com.leaniot.domain.attribute.DataType.Type)
	 */
	@Override
	public void setDataType(Type dataType) {
		this.dataType = dataType;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#isOptional()
	 */
	@Override
	public boolean isOptional() {
		return optional;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#setOptional(boolean)
	 */
	@Override
	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#getDataTypeInfos()
	 */
	@Override
	public Map<String, String> getDataTypeInfos() {
		return dataTypeInfos;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#setDataTypeInfos(java.util.Map)
	 */
	@Override
	public void setDataTypeInfos(Map<String, String> dataTypeInfos) {
		this.dataTypeInfos = dataTypeInfos;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#getAdditional()
	 */
	@Override
	public List<? extends AttTypeInfo> getAdditional() {
		return additional;
	}
	/* (non-Javadoc)
	 * @see com.leaniot.domain.attribute.IAttTypeInfo#setAdditional(java.util.List)
	 */
	@Override
	public void setAdditional(List<? extends AttTypeInfo> additional) {
		this.additional = additional;
	}
	
	protected void setAttribute(Boolean get, Boolean set, Boolean report) {
		this.getDataTypeInfos().put(DeviceAttributeType.GET, get.toString());
		this.getDataTypeInfos().put(DeviceAttributeType.SET, set.toString());
		this.getDataTypeInfos().put(DeviceAttributeType.REPORT, report.toString());
	}

}
