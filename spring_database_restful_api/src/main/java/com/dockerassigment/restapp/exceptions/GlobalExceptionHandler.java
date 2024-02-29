package com.dockerassigment.restapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.dockerassigment.restapp.response.ExceptionApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = NoResourceFoundException.class)
	protected ResponseEntity<ExceptionApiResponse> NoResourceFoundException(NoResourceFoundException ex){
		ExceptionApiResponse exceptionApiResponse = new ExceptionApiResponse();
		exceptionApiResponse.setMessage(ex.getMessage());
		return new ResponseEntity<ExceptionApiResponse>(exceptionApiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<ExceptionApiResponse> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
		ExceptionApiResponse exceptionApiResponse = new ExceptionApiResponse();
		exceptionApiResponse.setMessage(ex.getMessage());
		return new ResponseEntity<ExceptionApiResponse>(exceptionApiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<ExceptionApiResponse> Exception(Exception ex){
		ExceptionApiResponse exceptionApiResponse = new ExceptionApiResponse();
		exceptionApiResponse.setMessage(ex.getMessage());
		return new ResponseEntity<ExceptionApiResponse>(exceptionApiResponse,HttpStatus.NOT_FOUND);
	}

}
