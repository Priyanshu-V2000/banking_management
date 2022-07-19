package com.bank.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidStatusException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2567185611900959587L;
	private String errorCode;
	private String errorMessage;
	public InvalidStatusException() {
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

	public InvalidStatusException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
