package com.codeshinobis.cscurrencyexchangeapi.service.implementation;

import com.codeshinobis.cscurrencyexchangeapi.client.ApiGatewayClient;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeshinobis.cscurrencyexchangeapi.client.request.TransactionRequest;
import com.codeshinobis.cscurrencyexchangeapi.client.response.RatesResponse;
import com.codeshinobis.cscurrencyexchangeapi.mapper.TransactionToExchangeResponseMapper;
import com.codeshinobis.cscurrencyexchangeapi.model.ResponseDto;
import com.codeshinobis.cscurrencyexchangeapi.model.request.ExchangeRequest;
import com.codeshinobis.cscurrencyexchangeapi.model.response.ExchangeResponse;
import com.codeshinobis.cscurrencyexchangeapi.service.ExchangeService;

@Service
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ApiGatewayClient apiGatewayClient;
    
    @Override
    public ResponseDto<ExchangeResponse> createExchangeTransaction(String userID, ExchangeRequest exchangeRequest) {
        log.info("Exchange Request - Source : {} | Target : {} | Amount : {}",
            exchangeRequest.getSourceCurrency(), exchangeRequest.getTargetCurrency(), exchangeRequest.getAmount());
        
        RatesResponse ratesResponse = 
            apiGatewayClient.getExchangeRate(exchangeRequest.getSourceCurrency(), exchangeRequest.getTargetCurrency()).getData();
        double convertedAmount = this.convertCurrency(exchangeRequest.getAmount(), ratesResponse.getExchangeRate());
        log.info("Exchange Rate - {} | Converted Amount - {}", ratesResponse.getExchangeRate(), convertedAmount);

        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setUserID(userID);
        transactionRequest.setSourceCurrency(exchangeRequest.getSourceCurrency());
        transactionRequest.setTargetCurrency(exchangeRequest.getTargetCurrency());
        transactionRequest.setRequestAmount(exchangeRequest.getAmount());
        transactionRequest.setConvertedAmount(convertedAmount);
        transactionRequest.setExchangeRate(ratesResponse.getExchangeRate());

        ExchangeResponse exchangeResponse = 
            TransactionToExchangeResponseMapper.INSTANCE.map(apiGatewayClient.createTransaction(transactionRequest).getData());
        log.info("Transaction ID - {}", exchangeResponse.getTransactionID());

        return ResponseDto.forSuccess(exchangeResponse);
    }

    private double convertCurrency(double requestAmount, double exchangeRate) {
        return requestAmount * exchangeRate;
    }

}
