package com.codeshinobis.cscurrencyratesapi.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeshinobis.cscurrencyratesapi.model.CurrencyExchangeRates;

@Repository
public interface CurrencyExchangeRatesRepo extends JpaRepository<CurrencyExchangeRates, Long> {

	Optional<CurrencyExchangeRates> findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);
	
	List<CurrencyExchangeRates> findAll();
}
