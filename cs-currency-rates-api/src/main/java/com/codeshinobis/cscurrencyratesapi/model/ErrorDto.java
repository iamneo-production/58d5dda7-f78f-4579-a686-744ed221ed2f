package com.codeshinobis.cscurrencyratesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class ErrorDto {

    private String code;
    private String message;
    
    
	public ErrorDto(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ErrorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
