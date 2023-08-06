package com.codeshinobis.cscurrencyexchangeapi.client;

import com.codeshinobis.cscurrencyexchangeapi.client.request.TransactionRequest;
import com.codeshinobis.cscurrencyexchangeapi.client.response.RatesResponse;
import com.codeshinobis.cscurrencyexchangeapi.client.response.TransactionResponse;
import com.codeshinobis.cscurrencyexchangeapi.model.LogDto;
import com.codeshinobis.cscurrencyexchangeapi.model.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "cs-api-gateway")
public interface ApiGatewayClient {

    @PostMapping("/api/cs/logger/log")
    void sendLog(LogDto logDto);

    @GetMapping("/api/cs/currency-rates/rates/{sourceCurrency}/{targetCurrency}")
    ResponseDto<RatesResponse> getExchangeRate(@PathVariable String sourceCurrency, @PathVariable String targetCurrency);

    @PostMapping("/api/cs/exchange-transactions/transaction")
    ResponseDto<TransactionResponse> createTransaction(TransactionRequest transactionRequest);

}
