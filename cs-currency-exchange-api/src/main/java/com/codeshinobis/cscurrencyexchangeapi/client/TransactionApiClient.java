package com.codeshinobis.cscurrencyexchangeapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.codeshinobis.cscurrencyexchangeapi.client.request.TransactionRequest;
import com.codeshinobis.cscurrencyexchangeapi.client.response.TransactionResponse;
import com.codeshinobis.cscurrencyexchangeapi.model.ResponseDto;

@FeignClient(value = "transaction-api", url="lb://cs-transaction-api")
public interface TransactionApiClient {


    @PostMapping("/api/cs/exchange-transactions/transaction")
    ResponseDto<TransactionResponse> createTransaction(TransactionRequest transactionRequest);
    
}
