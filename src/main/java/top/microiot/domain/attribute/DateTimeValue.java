package top.microiot.domain.attribute;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import top.microiot.exception.ValueException;

public class DateTimeValue extends DataValue {
	private String date;
	private String format;

	public DateTimeValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateTimeValue(AttValueInfo value, DateTimeType type)  {
		if(!type.isValid(value))
			throw new ValueException("invalid datetime value");
		
		this.date = value.getValue();
		this.format = type.getFormat();
	}

	public DateTimeValue(String value, String format) {
		DateTimeType type = new DateTimeType(format);
		if(!type.isValid(value))
			throw new ValueException("invalid datetime value");
		
		this.date = value;
		this.format = format;
	}
	@JsonIgnore
	public Date getValue() throws ParseException {
		return new SimpleDateFormat(format).parse(date);
	}

	public void setValue(String value) {
		this.date = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String getString() {
		return date;
	}

	
}
