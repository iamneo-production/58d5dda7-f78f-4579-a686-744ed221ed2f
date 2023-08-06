package com.codeshinobis.cscurrencyratesapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeshinobis.cscurrencyratesapi.exception.SourceCurrencyException;
import com.codeshinobis.cscurrencyratesapi.exception.TargetCurrencyException;
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
	public ResponseEntity<ResponseDto<Object>> getCurrencyExchangeRates(
	        @PathVariable("sourceCurrency") String sourceCurrency,
	        @PathVariable("targetCurrency") String targetCurrency) throws SourceCurrencyException, TargetCurrencyException {
	    try {
	        CurrencyExchangeRates rate = service.getCurrencyRate(sourceCurrency, targetCurrency)
	                .orElseThrow(NoSuchElementException::new);
	        double exchange_rate = rate.getExchange_rate();
	        //ResponseDto<Double> responseDto = ResponseDto.forSuccess(exchange_rate);
	        return ResponseEntity.ok(ResponseDto.forSuccess(exchange_rate));
	    } catch (NoSuchElementException e) {
	        List<ErrorDto> errorList = new ArrayList<>();
	        
	        if (service.getCurrencyBySourceCurrency(sourceCurrency).isEmpty()) {
	            ErrorDto errorDto1 = new ErrorDto("1000", "Source Currency Type Not Exist");
	            errorList.add(errorDto1);
	        }
	        if (service.getCurrencyByTargetCurrency(targetCurrency).isEmpty()) {
	            ErrorDto errorDto2 = new ErrorDto("1001", "Target Currency Type Not Exist");
	            errorList.add(errorDto2);
	        }
	        
	        // Add the general currency type not exist error message
//	        ErrorDto errorDto = new ErrorDto("1003", "Currency Type Not Exist");
//	        errorList.add(errorDto);
	        
	        // Create the error response with the error list
	        ResponseDto<Object> errorResponse = ResponseDto.forError(errorList);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	    }
	}

	
	@GetMapping("/all")
	public List<CurrencyExchangeRates> getAllRates(){
		return repo.findAll();
	}
	
	@GetMapping("/{sourceCurrency}")
	public List<CurrencyExchangeRates> getCurrency(@PathVariable("sourceCurrency") String sourceCurrency) {
	    return repo.findBySourceCurrency(sourceCurrency);
	}

	
}
