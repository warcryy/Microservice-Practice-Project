package com.discovery.service_discovery2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceDiscovery2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscovery2Application.class, args);
	}

}
