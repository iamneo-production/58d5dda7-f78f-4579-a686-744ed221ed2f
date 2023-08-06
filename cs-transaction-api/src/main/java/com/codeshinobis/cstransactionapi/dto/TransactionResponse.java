package com.codeshinobis.cstransactionapi.dto;

import com.codeshinobis.cstransactionapi.entity.Transaction;

//@Entity
public class TransactionResponse {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	double id;
	String status;
	Transaction data;
	String error;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Transaction getData() {
		return data;
	}
	public void setData(Transaction data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public TransactionResponse(String status, Transaction data, String error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TransactionResponse [status=" + status + ", data=" + data + ", error=" + error + "]";
	} 
	
	
	

}
