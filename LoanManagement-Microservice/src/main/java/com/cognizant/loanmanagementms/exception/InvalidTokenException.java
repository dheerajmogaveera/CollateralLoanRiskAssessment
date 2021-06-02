package com.cognizant.loanmanagementms.exception;
/**
 * Exception class
*throw exception for invalid Authorization
* 
*/
public class InvalidTokenException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public InvalidTokenException(String message) {
		super(message);
	}
	
	

}
