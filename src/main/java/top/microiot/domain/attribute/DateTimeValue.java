package top.microiot.domain.attribute;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import top.microiot.exception.ValueException;

public class DateTimeValue extends DataValue {
	private Date value;
	private DateTimeType dateTimeType;

	public DateTimeValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateTimeValue(AttValueInfo value, DateTimeType type)  {
		if(!type.isValid(value))
			throw new ValueException("invalid datetime value");
		SimpleDateFormat dateFormat = new SimpleDateFormat(type.getFormat());  
		try {
			this.value = dateFormat.parse(value.getValue());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dateTimeType = type;
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	@Override
	public String getString() {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat(dateTimeType.getFormat());
		return formatter.format(value);
	}

	
}
