package com.cognizant.loanmanagementms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.loanmanagementms.model.ErrorDetails;

import feign.FeignException;

/**
 * 
 *This class is annotated with @ControllerAdvice which means that this class 
 *will be able to handle the exceptions 
 *occured from any of the Controllers
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The @ExceptionHandler annotation is required to handle the type of exceptions which are 
	 * thrown and the corresponding method will be able to 
	 * handle the exceptions.
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({InvalidTokenException.class,FeignException.class})
	public ResponseEntity<ErrorDetails> invalidAuthorizationHandler(Exception exception) {
		var errorDetails = new ErrorDetails( exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler({CustomerLoanNotFoundException.class,CollateralNotFoundException.class})
	public ResponseEntity<ErrorDetails> customerLoanNotFoundExceptionHandler(Exception exception) {
		var errorDetails = new ErrorDetails( exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
