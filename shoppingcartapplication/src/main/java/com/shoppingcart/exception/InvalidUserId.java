package com.shoppingcart.exception;

/**
 * 
 * @author Vitthal Baburao
 *
 */
public class InvalidUserId extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidUserId() {
		super();
	}

	public InvalidUserId(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUserId(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserId(String message) {
		super(message);
	}

	public InvalidUserId(Throwable cause) {
		super(cause);
	}

}
