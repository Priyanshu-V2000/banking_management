package com.bank.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(EmptyInputException.class)		//user generated
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException){
		logger.error("EmptyInputException : "+ emptyInputException.getMessage() + " " + emptyInputException.getErrorCode());
		return new ResponseEntity<String>("EmptyInputException : "+emptyInputException.getErrorCode()+" // "+emptyInputException.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)		//predefined
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException){
		logger.error("NoSuchElementException : "+ elementException.getMessage());
		return new ResponseEntity<String>("Customer Adhaar/Account no does not exist ,please look at it",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountIdException.class)		//user generated
	public ResponseEntity<String> handleAccountIdException(AccountIdException acIdException){
		logger.error("AccountIdException : "+ acIdException.getMessage() + " " + acIdException.getErrorCode());
		return new ResponseEntity<String>("AcIdException : "+acIdException.getErrorCode()+" // "+acIdException.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InsufficientBalanceException.class)		//user generated
	public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException insufficientBalanceException){
		logger.error("InsufficientBalanceException : "+ insufficientBalanceException.getMessage() + " " + insufficientBalanceException.getErrorCode());
		return new ResponseEntity<String>("InsufficientBalanceException : " + insufficientBalanceException.getErrorCode() + "//" + insufficientBalanceException.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AccountIdMustBeNullException.class)		//user generated
	public ResponseEntity<String> handleAccountIdMustBeNullException(AccountIdMustBeNullException accountIdMustBeNullException){
		logger.error("AccountIdMustBeNullException : "+ accountIdMustBeNullException.getMessage() + " " + accountIdMustBeNullException.getErrorCode());
		return new ResponseEntity<String>("AccountIdMustBeNullException : " + accountIdMustBeNullException.getErrorCode() + "//" + accountIdMustBeNullException.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(InvalidStatusException.class)		//user generated
	public ResponseEntity<String> handleInvalidStatusException(InvalidStatusException invalidStatusException){
		logger.error("InvalidStatusException : "+ invalidStatusException.getMessage() + " " + invalidStatusException.getErrorCode());
		return new ResponseEntity<String>("InvalidStatusException : " + invalidStatusException.getErrorCode() + "//" + invalidStatusException.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)		//user generated
	public ResponseEntity<String> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException customerAlreadyExistsException){
		logger.error("CustomerAlreadyExistsException : "+ customerAlreadyExistsException.getMessage() + " " + customerAlreadyExistsException.getErrorCode());
		return new ResponseEntity<String>("CustomerAlreadyExistsException : " + customerAlreadyExistsException.getErrorCode() + "//" + customerAlreadyExistsException.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(SizeLimitException.class)		//user generated
	public ResponseEntity<String> handleSizeLimitException(SizeLimitException sizeLimitException){
		logger.error("SizeLimitException : "+ sizeLimitException.getMessage() + " " + sizeLimitException.getErrorCode());
		return new ResponseEntity<String>("SizeLimitException : " + sizeLimitException.getErrorCode() + "//" + sizeLimitException.getErrorMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}





