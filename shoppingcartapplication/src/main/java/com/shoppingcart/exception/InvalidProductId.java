package com.shoppingcart.exception;

/**
 * 
 * @author Vitthal Baburao
 *
 */
public class InvalidProductId extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidProductId() {
		super();
	}

	public InvalidProductId(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidProductId(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidProductId(String message) {
		super(message);
	}

	public InvalidProductId(Throwable cause) {
		super(cause);
	}

}
