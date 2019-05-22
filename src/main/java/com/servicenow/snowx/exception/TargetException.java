package com.servicenow.snowx.exception;

public class TargetException extends AppException {

	private static final long serialVersionUID = 1L;

	public TargetException(final String message) {
		super("Target Exception: " + message);
	}
}
