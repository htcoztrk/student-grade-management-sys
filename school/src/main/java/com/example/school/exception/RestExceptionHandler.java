package com.example.school.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	//global exception handling
	//if any exception occurs in system, this method wil be called.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<ErrorMessage> handleValidationException(MethodArgumentNotValidException exceptions){
		List<ErrorMessage> errorMessage=new ArrayList<ErrorMessage>();
		for(FieldError error:exceptions.getBindingResult().getFieldErrors()) {
			errorMessage.add(new ErrorMessage(error.getField(),error.getDefaultMessage()));
		}
		return errorMessage;
		
	}
	
}
