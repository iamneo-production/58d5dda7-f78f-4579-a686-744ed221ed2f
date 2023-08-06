package com.codeshinobis.cscurrencyexchangeapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codeshinobis.cscurrencyexchangeapi.client.response.RatesResponse;
import com.codeshinobis.cscurrencyexchangeapi.model.ResponseDto;

@FeignClient(value = "rates-api", url="lb://cs-currency-rates-api")
public interface RatesApiClient {

    @GetMapping("/api/cs/currency-rates/rates/{sourceCurrency}/{targetCurrency}")
    ResponseDto<RatesResponse> getExchangeRate(@PathVariable String sourceCurrency, @PathVariable String targetCurrency);
    
}
