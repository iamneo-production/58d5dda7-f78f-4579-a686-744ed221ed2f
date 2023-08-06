package com.codeshinobis.cscurrencyexchangeapi.client.request;

import lombok.Data;

@Data
public class TransactionRequest {
    
    private String userID;
    private String sourceCurrency;
    private String targetCurrency;
    private double requestAmount;
    private double convertedAmount;
    private double exchangeRate;

}
