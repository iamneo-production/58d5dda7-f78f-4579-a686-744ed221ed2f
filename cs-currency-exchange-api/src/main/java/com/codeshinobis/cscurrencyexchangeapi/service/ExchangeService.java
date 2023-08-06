package com.codeshinobis.cscurrencyexchangeapi.service;

import com.codeshinobis.cscurrencyexchangeapi.model.ResponseDto;
import com.codeshinobis.cscurrencyexchangeapi.model.request.ExchangeRequest;
import com.codeshinobis.cscurrencyexchangeapi.model.response.ExchangeResponse;

public interface ExchangeService {

    ResponseDto<ExchangeResponse> createExchangeTransaction(String userID, ExchangeRequest exchangeRequest);

}
