package com.taohj.fms.exception;

public class UserExistException extends FmsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4451872252356247159L;

	public UserExistException() {
		super();
	}

	public UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserExistException(String message) {
		super(message);
	}

	public UserExistException(Throwable cause) {
		super(cause);
	}

}
