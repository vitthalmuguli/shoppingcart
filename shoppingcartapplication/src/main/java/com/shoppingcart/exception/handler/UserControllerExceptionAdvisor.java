package com.shoppingcart.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shoppingcart.exception.InvalidUserId;

import com.shoppingcart.response.CustomError;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@RestControllerAdvice
public class UserControllerExceptionAdvisor {

	@ExceptionHandler(InvalidUserId.class)
	public ResponseEntity<CustomError> userNotFound(InvalidUserId exception) {
		CustomError customError = new CustomError(exception.getMessage(), "204");
		return new ResponseEntity<CustomError>(customError, HttpStatus.ACCEPTED);
	}
}
