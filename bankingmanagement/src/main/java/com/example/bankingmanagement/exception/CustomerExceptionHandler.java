package com.example.bankingmanagement.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse>handleException(CustomerNotFoundException ex){
		
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMsg(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse>handleException(Exception ex){
		
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMsg(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}


}
