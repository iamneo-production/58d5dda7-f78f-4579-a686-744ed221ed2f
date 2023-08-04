package com.codeshinobis.csserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CsServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsServiceRegistryApplication.class, args);
	}

}
