package top.microiot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED)
public class StatusException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8066549427066767404L;

	public StatusException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
