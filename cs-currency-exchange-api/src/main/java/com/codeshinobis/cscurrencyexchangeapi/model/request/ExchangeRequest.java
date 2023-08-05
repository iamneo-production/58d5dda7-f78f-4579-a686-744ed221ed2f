package com.codeshinobis.cscurrencyexchangeapi.model.request;

import lombok.Data;

@Data
public class ExchangeRequest {
    
    private String sourceCurrency;
    private String targetCurrency;
    private double amount;

}
