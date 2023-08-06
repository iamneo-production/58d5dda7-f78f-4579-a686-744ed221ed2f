package com.codeshinobis.cstransactionapi.advice;


import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex){
		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "Something went wrong");
		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}
	
	

}

class ErrorMessage{
	private String message;
	private String details;
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
}
