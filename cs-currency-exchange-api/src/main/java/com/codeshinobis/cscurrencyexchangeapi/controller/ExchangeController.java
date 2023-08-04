package com.codeshinobis.cscurrencyexchangeapi.controller;

import lombok.extern.slf4j.Slf4j;

import com.codeshinobis.cscurrencyexchangeapi.model.ResponseDto;
import com.codeshinobis.cscurrencyexchangeapi.service.ExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/exchange-api")
@Slf4j
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/exchange")
    public ResponseEntity<ResponseDto<String>> exchangeCurrency() {
        return ResponseEntity.ok(ResponseDto.forSuccess("Hello!"));
    }

}
