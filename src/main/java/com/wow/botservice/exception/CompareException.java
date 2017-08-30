package com.wow.botservice.exception;

public class CompareException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public CompareException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public CompareException() {
		super();
	}
	
}