package com.codeshinobis.cscurrencyratesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class ResponseDto {

	private String status;
	private Double exchange_data;
//	private List<ErrorDto> errors;
	
	public String getStatus() {
		return status;
	}
	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseDto(String status, Double exchange_data) {
	super();
	this.status = status;
	this.exchange_data = exchange_data;
}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getExchange_data() {
		return exchange_data;
	}
	public void setExchange_data(Double exchange_data) {
		this.exchange_data = exchange_data;
	}
	
	
	
}
