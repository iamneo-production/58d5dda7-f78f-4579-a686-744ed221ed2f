package com.codeshinobis.csuserprofileapi.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserTransaction {

    private long transactionId;
    private String sourceCurrency;
    private String targetCurrency;
    private double requestAmount;
    private double convertedAmount;
    private double exchangeRate;
    private Date transactionDateTime;
    
}
