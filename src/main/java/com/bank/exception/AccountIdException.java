package com.bank.exception;

import org.springframework.stereotype.Component;

@Component
public class AccountIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 486264072012748438L;
	private String errorCode;
	private String errorMessage;
	public AccountIdException() {
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

	public AccountIdException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
}
