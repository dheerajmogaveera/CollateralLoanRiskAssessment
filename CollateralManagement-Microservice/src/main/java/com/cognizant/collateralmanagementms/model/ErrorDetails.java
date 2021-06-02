package com.cognizant.collateralmanagementms.model;

import java.util.Date;


/** pojo class for error details
 *
 */
public class ErrorDetails {

	private Date date;
	private String message;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorDetails(Date date, String message) {
		super();
		this.date = date;
		this.message = message;
	}
	public ErrorDetails() {
		
	}
	
	
}
