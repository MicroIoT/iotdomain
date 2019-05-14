package top.microiot.domain.attribute;

import top.microiot.exception.ValueException;

public class DeviceAttributeType extends AttributeType {
	public static final String REPORT = "attribute.report";
	public static final String SET = "attribute.set";
	public static final String GET = "attribute.get";
	private boolean get;
	private boolean set;
	private boolean report;
	
	public DeviceAttributeType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceAttributeType(AttTypeInfo type) {
		super(type);
		if(type.getDataTypeInfos() == null)
			throw new ValueException("no definition of get, set, report");
		String getValue = type.getDataTypeInfos().get(GET);
		if(getValue == null)
			throw new ValueException("no definition of get");
		this.get = Boolean.parseBoolean(getValue);
		String setValue = type.getDataTypeInfos().get(SET);
		if(setValue == null)
			throw new ValueException("no definition of set");
		this.set = Boolean.parseBoolean(setValue);
		String reportValue = type.getDataTypeInfos().get(REPORT);
		if(reportValue == null)
			throw new ValueException("no definition of report");
		this.report = Boolean.parseBoolean(reportValue);
	}

	public boolean isGet() {
		return get;
	}

	public void setGet(boolean get) {
		this.get = get;
	}

	public boolean isSet() {
		return set;
	}

	public void setSet(boolean set) {
		this.set = set;
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}
}
