package com.shoppingcart.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shoppingcart.exception.InvalidProductId;
import com.shoppingcart.response.CustomError;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@RestControllerAdvice
public class ProductControllerExceptionAdvisor {

	@ExceptionHandler(InvalidProductId.class)
	public ResponseEntity<CustomError> productNotFound(InvalidProductId exception) {
		CustomError customError = new CustomError(exception.getMessage(), "202");
		return new ResponseEntity<CustomError>(customError, HttpStatus.ACCEPTED);
	}
}
