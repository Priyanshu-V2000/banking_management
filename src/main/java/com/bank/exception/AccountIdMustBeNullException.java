package com.bank.exception;

import org.springframework.stereotype.Component;

@Component
public class AccountIdMustBeNullException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3516570401458800123L;
	private String errorCode;
	private String errorMessage;
	public AccountIdMustBeNullException() {
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

	public AccountIdMustBeNullException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
