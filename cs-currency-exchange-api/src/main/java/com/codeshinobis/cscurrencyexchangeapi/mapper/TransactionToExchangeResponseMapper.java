package com.codeshinobis.cscurrencyexchangeapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codeshinobis.cscurrencyexchangeapi.client.response.TransactionResponse;
import com.codeshinobis.cscurrencyexchangeapi.model.response.ExchangeResponse;

@Mapper
public interface TransactionToExchangeResponseMapper {

    static final TransactionToExchangeResponseMapper INSTANCE = Mappers.getMapper(TransactionToExchangeResponseMapper.class);

    abstract ExchangeResponse map(TransactionResponse transactionResponse);
    
}
