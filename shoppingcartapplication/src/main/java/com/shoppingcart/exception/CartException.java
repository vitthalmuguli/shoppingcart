package com.shoppingcart.exception;

/**
 * 
 * @author Vitthal Baburao
 *
 */
public class CartException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CartException() {
		super();
	}

	public CartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CartException(String message, Throwable cause) {
		super(message, cause);
	}

	public CartException(String message) {
		super(message);
	}

	public CartException(Throwable cause) {
		super(cause);
	}
}
