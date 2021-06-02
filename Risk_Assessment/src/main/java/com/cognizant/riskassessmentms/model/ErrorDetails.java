package com.cognizant.riskassessmentms.model;

/** pojo class for error details
 *
 */
public class ErrorDetails {

	
	private String message;
	
	public ErrorDetails(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorDetails() {
		super();
	}
	
	
}
