package com.codeshinobis.cscurrencyratesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeshinobis.cscurrencyratesapi.model.CurrencyExchangeRates;
import com.codeshinobis.cscurrencyratesapi.repo.CurrencyExchangeRatesRepo;

@Service
public class CurrencyRatesService {
	
	 @Autowired
	 CurrencyExchangeRatesRepo repo;
	
	 public Optional<CurrencyExchangeRates> getCurrencyRate(String sourceCurrency, String targetCurrency) {
	        return repo.findBySourceCurrencyAndTargetCurrency(sourceCurrency, targetCurrency);
	 }

	 public List<CurrencyExchangeRates> getCurrencyBySourceCurrency(String sourceCurrency) {
		 return repo.findBySourceCurrency(sourceCurrency);
	 }
	 
	 public List<CurrencyExchangeRates> getCurrencyByTargetCurrency(String sourceCurrency) {
		 return repo.findBySourceCurrency(sourceCurrency);
	 }

}
