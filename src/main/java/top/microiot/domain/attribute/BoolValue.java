package top.microiot.domain.attribute;

public class BoolValue extends DataValue {
	private Boolean value;
	
	public BoolValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoolValue(Boolean value) {
		super();
		this.value = value;
	}

	public BoolValue(String value){
		if(value.equalsIgnoreCase("true"))
			this.value = true;
		if(value.equalsIgnoreCase("false"))
			this.value = false;
	}
	
	
	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	@Override
	public String getString() {
		return value.toString();
	}

}
