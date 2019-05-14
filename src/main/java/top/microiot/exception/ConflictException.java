package top.microiot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 48111429531037056L;

	public ConflictException(String object) {
		super(object + " conflict");
		// TODO Auto-generated constructor stub
	}
}
