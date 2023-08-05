package com.codeshinobis.csloggerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CsLoggerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsLoggerApiApplication.class, args);
	}

}
