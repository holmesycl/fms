package com.taohj.fms.exception;

public class FmsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1835808405377882748L;

	public FmsException() {
		super();
	}

	public FmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FmsException(String message, Throwable cause) {
		super(message, cause);
	}

	public FmsException(String message) {
		super(message);
	}

	public FmsException(Throwable cause) {
		super(cause);
	}

}
