package com.codeshinobis.cstransactionapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CsTransactionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsTransactionApiApplication.class, args);
	}

}
