package com.shoppingcart.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shoppingcart.exception.CartException;

import com.shoppingcart.exception.InvalidProductId;
import com.shoppingcart.exception.InvalidUserId;
import com.shoppingcart.exception.ParsingException;

import com.shoppingcart.response.CustomError;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@RestControllerAdvice
public class CartControllerExceptionAdvisor {

	@ExceptionHandler(CartException.class)
	public ResponseEntity<CustomError> cartIsEmpty(CartException exception) {
		CustomError customError = new CustomError(exception.getMessage(), "204");
		return new ResponseEntity<CustomError>(customError, HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(InvalidUserId.class)
	public ResponseEntity<CustomError> userNotFound(InvalidUserId exception) {
		CustomError customError = new CustomError(exception.getMessage(), "204");
		return new ResponseEntity<CustomError>(customError, HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(InvalidProductId.class)
	public ResponseEntity<CustomError> productNotFound(InvalidProductId exception) {
		CustomError customError = new CustomError(exception.getMessage(), "204");
		return new ResponseEntity<CustomError>(customError, HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(ParsingException.class)
	public ResponseEntity<CustomError> productIdParsingError(ParsingException exception) {
		CustomError customError = new CustomError(exception.getMessage(), "204");
		return new ResponseEntity<CustomError>(customError, HttpStatus.ACCEPTED);
	}
}
