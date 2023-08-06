package com.codeshinobis.cstransactionapi.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TransactionResponse {
    
    private String userID;
    private long transactionID;
    private String sourceCurrency;
    private String targetCurrency;
    private double requestAmount;
    private double convertedAmount;
    private double exchangeRate;
    private Date transactionDateTime;

}
