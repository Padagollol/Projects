package com.example.bankingmanagement.exception;

public class TransactionNotFoundException extends RuntimeException {
	public TransactionNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TransactionNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TransactionNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TransactionNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
