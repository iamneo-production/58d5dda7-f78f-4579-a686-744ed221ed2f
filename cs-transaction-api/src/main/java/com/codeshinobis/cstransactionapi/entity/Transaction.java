package com.codeshinobis.cstransactionapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long transactionId;
	String sourceCurrency;
	String targetCurrency;
	double requestAmount;
	double convertedAmount;
	double exchangeRate;
	String transactionDateTime;
	String userId;
	public long getId() {
		return transactionId;
	}
	public void setId(long transactionId) {
		this.transactionId = transactionId;
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
	public String getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Transaction(long transactionId, String sourceCurrency, String targetCurrency, double requestAmount,
			double convertedAmount, double exchangeRate, String transactionDataTime, String userId) {
		super();
		this.transactionId = transactionId;
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.requestAmount = requestAmount;
		this.convertedAmount = convertedAmount;
		this.exchangeRate = exchangeRate;
		this.transactionDateTime = transactionDateTime;
		this.userId = userId;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", sourceCurrency=" + sourceCurrency + ", targetCurrency=" + targetCurrency
				+ ", requestAmount=" + requestAmount + ", convertedAmount=" + convertedAmount + ", exchangeRate="
				+ exchangeRate + ", transactionDateTime=" + transactionDateTime + ", userId=" + userId + "]";
	}
	
	

}
