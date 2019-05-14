package top.microiot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class ValueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4823537636664009518L;

	public ValueException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
