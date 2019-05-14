package top.microiot.domain.attribute;

public class DecimalValue extends DataValue {
	private Double value;
	
	public DecimalValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DecimalValue(Double value) {
		super();
		this.value = value;
	}

	public DecimalValue(String value){
		this.value = Double.parseDouble(value);
	}
	
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String getString() {
		return value.toString();
	}

}
