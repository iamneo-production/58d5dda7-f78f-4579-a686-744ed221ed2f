package com.codeshinobis.cstransactionapi.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity
public class TransactionRequest {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
	String sourceCurrency;
	String targetCurrency;
	double requestAmount;
	double convertedAmount;
	double exchangeRate;
	String userId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public double getRequestAmount() {
		return requestAmount;
	}
	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}
	public double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public TransactionRequest(long id, String sourceCurrency, String targetCurrency, double requestAmount,
			double convertedAmount, double exchangeRate, String userId) {
		super();
		this.id = id;
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.requestAmount = requestAmount;
		this.convertedAmount = convertedAmount;
		this.exchangeRate = exchangeRate;
		this.userId = userId;
	}
	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TransactionRequest{" +
				"id=" + id +
				", sourceCurrency='" + sourceCurrency + '\'' +
				", targetCurrency='" + targetCurrency + '\'' +
				", requestAmount=" + requestAmount +
				", convertedAmount=" + convertedAmount +
				", exchangeRate=" + exchangeRate +
				", userId='" + userId + '\'' +
				'}';
	}
}
