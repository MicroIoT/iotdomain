package top.microiot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class AuthenticationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7921118759202969666L;
	public static final String TOKEN_EXPIRED = "JWT Token expired";
	public static final String TOKEN_NOT_EXIST = "JWT Token not exist";
	public AuthenticationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
