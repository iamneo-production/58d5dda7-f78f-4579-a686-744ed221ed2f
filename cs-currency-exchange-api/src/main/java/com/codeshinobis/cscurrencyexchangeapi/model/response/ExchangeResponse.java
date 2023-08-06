package com.codeshinobis.cscurrencyexchangeapi.model.response;

import java.util.Date;

import lombok.Data;

@Data
public class ExchangeResponse {
    
    private long transactionID;
    private String sourceCurrency;
    private String targetCurrency;
    private double requestAmount;
    private double convertedAmount;
    private double exchangeRate;
    private Date transactionDateTime;

}
