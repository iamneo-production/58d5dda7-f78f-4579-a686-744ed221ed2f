package com.codeshinobis.cscurrencyratesapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
// @AllArgsConstructor
@Getter
public class CurrencyExchangeRates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="source_currency")
	private String sourceCurrency;
	@Column(name="target_currency")
	private String targetCurrency;
	@Column
	private double exchange_rate;
	
	
	public CurrencyExchangeRates(long id, String sourceCurrency, String targetCurrency, double exchange_rate) {
		super();
		this.id = id;
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.exchange_rate = exchange_rate;
	}
	
	public CurrencyExchangeRates() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	public double getExchange_rate() {
		return exchange_rate;
	}
	public void setExchange_rate(double exchange_rate) {
		this.exchange_rate = exchange_rate;
	}
	@Override
	public String toString() {
		return "CurrencyExchangeRates [id=" + id + ", sourceCurrency=" + sourceCurrency + ", targetCurrency="
				+ targetCurrency + ", exchange_rate=" + exchange_rate + "]";
	}
	
	
}
