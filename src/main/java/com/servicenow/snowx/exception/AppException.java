package com.servicenow.snowx.exception;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;

	public AppException(final String message) {
		super("Application Exception: " + message);
	}
}
