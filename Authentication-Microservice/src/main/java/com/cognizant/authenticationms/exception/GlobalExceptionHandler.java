package com.cognizant.authenticationms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.authenticationms.model.ErrorDetails;


/**
 * 
 *This class is annotated with @ControllerAdvice which means that this class 
 *will be able to handle the exceptions 
 *occured from any of the Controllers
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	/**
	 * The @ExceptionHandler annotation is required to handle the type of exceptions which are 
	 * thrown and the corresponding method will be able to 
	 * handle the exceptions.
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({InvalidCredentialsException.class})
	public ResponseEntity<ErrorDetails> invalidAuthorizationHandler(Exception exception) {
		com.cognizant.authenticationms.model.ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}

}
