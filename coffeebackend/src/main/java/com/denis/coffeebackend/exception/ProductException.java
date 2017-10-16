package com.denis.coffeebackend.exception;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	ProductException() {
		super();
	}

	public ProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductException(Throwable cause) {
		super(cause);
	}

	public ProductException(String message) {
		super(message);
	}

}
