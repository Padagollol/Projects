package com.example.bankingmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionHandler {
	

	@ExceptionHandler
	public ResponseEntity<TransactionErrorResponse>handleException(TransactionNotFoundException ex){
		
		TransactionErrorResponse error = new TransactionErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMsg(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
		
		@ExceptionHandler
		public ResponseEntity<TransactionErrorResponse>handleException(Exception ex){
			
			TransactionErrorResponse error = new TransactionErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMsg(ex.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
			
		}
		
	}
