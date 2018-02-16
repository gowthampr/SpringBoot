package com.gowtham.springboots.microservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GenericExceptionControllerAdvice extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler({Exception.class})
	ResponseEntity<Object> handleExceptions(Exception ex, WebRequest wr){
		
		return new ResponseEntity<Object>(new CustomizedExceptionMessage(ex.getMessage(), wr.getDescription(false), new Date()), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler({UserNotFoundException.class})
	ResponseEntity<Object> handleUserExceptions(UserNotFoundException ex, WebRequest wr){
		
		return new ResponseEntity<Object>(new CustomizedExceptionMessage(ex.getMessage(), wr.getDescription(false), new Date()), HttpStatus.NOT_FOUND);
		
	}
	
	
}
