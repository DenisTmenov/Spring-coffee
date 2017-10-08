package com.denis.coffeebackend.exception;

public class CategoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	CategoryException() {
		super();
	}

	public CategoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoryException(Throwable cause) {
		super(cause);
	}

	public CategoryException(String message) {
		super(message);
	}

}
