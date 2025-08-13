package com.aaslin.ExceptionHandlingInputValidationShowcase.Exceptions;

public class NotFoundException extends RuntimeException{
	public NotFoundException(String message) {
		super(message);
	}
}
