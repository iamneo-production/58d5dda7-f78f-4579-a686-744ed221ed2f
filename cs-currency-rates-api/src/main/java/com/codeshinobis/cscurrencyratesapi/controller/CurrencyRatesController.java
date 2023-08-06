package com.codeshinobis.cscurrencyratesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeshinobis.cscurrencyratesapi.model.CurrencyExchangeRates;
import com.codeshinobis.cscurrencyratesapi.model.ResponseDto;
import com.codeshinobis.cscurrencyratesapi.repo.CurrencyExchangeRatesRepo;
import com.codeshinobis.cscurrencyratesapi.service.CurrencyRatesService;


@RestController
@RequestMapping("/api/rates")
public class CurrencyRatesController {

	@Autowired
	CurrencyRatesService service;
	
	@Autowired
	CurrencyExchangeRatesRepo repo;
	
	@GetMapping("/hi")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("hello");
	}
	
	@GetMapping("/{sourceCurrency}/{targetCurrency}")
	public ResponseDto getCurrencyExchangeRates(@PathVariable("sourceCurrency") String sourceCurrency,
			@PathVariable("targetCurrency") String targetCurrency) {
		CurrencyExchangeRates rate=service.getCurrencyRate(sourceCurrency, targetCurrency).get();
		double exchange_rate=rate.getExchange_rate();
		ResponseDto responseDto=new ResponseDto("success",exchange_rate);
        return responseDto;
	}
	
	@GetMapping("/all")
	public List<CurrencyExchangeRates> getAllRates(){
		return repo.findAll();
	}
}
