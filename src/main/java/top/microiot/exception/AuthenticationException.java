package top.microiot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class AuthenticationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7921118759202969666L;
	public AuthenticationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
