package com.codeshinobis.cscurrencyratesapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeshinobis.cscurrencyratesapi.model.CurrencyExchangeRates;
import com.codeshinobis.cscurrencyratesapi.model.ErrorDto;
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
	public ResponseEntity<ResponseDto<Double>> getCurrencyExchangeRates(@PathVariable("sourceCurrency") String sourceCurrency,
			@PathVariable("targetCurrency") String targetCurrency) {
		try {
            CurrencyExchangeRates rate = service.getCurrencyRate(sourceCurrency, targetCurrency).orElseThrow(NoSuchElementException::new);
            double exchange_rate = rate.getExchange_rate();
            ResponseDto<Double> responseDto = ResponseDto.forSuccess(exchange_rate);
            return ResponseEntity.ok(responseDto);
        } catch (NoSuchElementException e) {
            ErrorDto errorDto = new ErrorDto("9330","Currency rate not found.");
            ResponseDto<Object> errorResponse = ResponseDto.forError(List.of(errorDto));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body((ResponseDto<Double>) (ResponseDto<?>) errorResponse);
        }
        
	}
	
	@GetMapping("/all")
	public List<CurrencyExchangeRates> getAllRates(){
		return repo.findAll();
	}
}
