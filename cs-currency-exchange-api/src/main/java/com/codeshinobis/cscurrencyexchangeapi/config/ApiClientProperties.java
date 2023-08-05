package com.codeshinobis.cscurrencyexchangeapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@ConfigurationProperties(prefix="api.client")
@Data
@Slf4j
public class ApiClientProperties {

    @Value("${ratesApiUrl}")
    private String ratesApiUrl;

    @Value("${transactionApiUrl}")
    private String transactionApiUrl;

    @PostConstruct
    private void printProperties() {
        log.info("Transaction API URL - {} ; Rates API URL - {}", transactionApiUrl, ratesApiUrl);
    }
    
}
