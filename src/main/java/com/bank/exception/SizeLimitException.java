package com.bank.exception;

import org.springframework.stereotype.Component;

@Component
public class SizeLimitException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5853745533021248489L;
	private String errorCode;
	private String errorMessage;
	public SizeLimitException() {
		super();
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public SizeLimitException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
