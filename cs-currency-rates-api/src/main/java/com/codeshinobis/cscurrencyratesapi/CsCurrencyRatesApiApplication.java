package com.codeshinobis.cscurrencyratesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CsCurrencyRatesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsCurrencyRatesApiApplication.class, args);
	}

}
