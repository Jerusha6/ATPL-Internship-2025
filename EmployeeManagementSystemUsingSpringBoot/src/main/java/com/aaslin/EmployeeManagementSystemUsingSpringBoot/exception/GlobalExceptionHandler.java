package com.aaslin.EmployeeManagementSystemUsingSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Errors;

@ControllerAdvice
public class GlobalExceptionHandler  {

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Errors> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		StringBuilder errorMessage = new StringBuilder();
		ex.getBindingResult().getAllErrors().forEach(error->errorMessage.append(error.getDefaultMessage()).append(", "));
		
		// Remove last comma and space if it exists
        if (errorMessage.length() > 0) {
            errorMessage.setLength(errorMessage.length() - 2);
        }
        Errors error = new Errors(errorMessage.toString(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleNotFoundException(EmployeeNotFoundException ex){
		StringBuilder errorMessage = new StringBuilder();
		
        return ex.getMessage();
	}
}
