package com.codeshinobis.cscurrencyexchangeapi.controller;

import lombok.extern.slf4j.Slf4j;

import com.codeshinobis.cscurrencyexchangeapi.exception.CsErrorCodes;
import com.codeshinobis.cscurrencyexchangeapi.exception.CsException;
import com.codeshinobis.cscurrencyexchangeapi.model.ResponseDto;
import com.codeshinobis.cscurrencyexchangeapi.model.request.ExchangeRequest;
import com.codeshinobis.cscurrencyexchangeapi.model.response.ExchangeResponse;
import com.codeshinobis.cscurrencyexchangeapi.service.ExchangeService;

import jakarta.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/currency-exchange")
@Slf4j
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @PostMapping("/exchange")
    public ResponseEntity<ResponseDto<ExchangeResponse>> exchangeCurrency(HttpServletRequest request, 
                        @RequestBody ExchangeRequest exchangeRequest) throws CsException {
        String userID = request.getHeader("USER_ID");
        validateExchangeRequest(exchangeRequest);
        validateUserID(userID);
        return ResponseEntity.ok(exchangeService.createExchangeTransaction(userID, exchangeRequest));
    }

    private void validateExchangeRequest(ExchangeRequest exchangeRequest) throws CsException {
        if (ObjectUtils.isEmpty(exchangeRequest) 
                || StringUtils.isBlank(exchangeRequest.getSourceCurrency())
                || StringUtils.isBlank(exchangeRequest.getTargetCurrency())
                || exchangeRequest.getAmount() <= 0) {
            log.info("Invalid Exchange Request Fields");
            throw new CsException(CsErrorCodes.INVALID_REQUEST);
        }
    }

    private void validateUserID(String userID) throws CsException {
        if (StringUtils.isBlank(userID)) {
            log.info("Invalid User ID - {}", userID);
            throw new CsException(CsErrorCodes.UNAUTHORIZED_USER);
        }
    }

}
