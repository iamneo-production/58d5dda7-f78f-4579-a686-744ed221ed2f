package com.codeshinobis.cscurrencyratesapi.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codeshinobis.cscurrencyratesapi.model.ErrorDto;
import com.codeshinobis.cscurrencyratesapi.model.ResponseDto;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(SourceCurrencyException.class)
	public ResponseEntity<ResponseDto<Object>> SourceCurrencyException(SourceCurrencyException ex,HttpServletRequest req){
		ErrorDto error=new ErrorDto("9001", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.forError(Arrays.asList(error)));
	}
	
	@ExceptionHandler(TargetCurrencyException.class)
	public ResponseEntity<ResponseDto<Object>> TargetCurrencyException(SourceCurrencyException ex,HttpServletRequest req){
		ErrorDto error=new ErrorDto("9002", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.forError(Arrays.asList(error)));
	}

	
}
