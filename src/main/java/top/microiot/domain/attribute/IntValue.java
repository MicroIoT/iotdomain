package top.microiot.domain.attribute;

public class IntValue extends DataValue {
	private Integer value;
	
	public IntValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IntValue(Integer value) {
		super();
		this.value = value;
	}

	public IntValue(String value){
		this.value = Integer.parseInt(value);
	}
	
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String getString() {
		return value.toString();
	}

}
