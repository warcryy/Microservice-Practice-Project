package com.embarkx.service_reg;

import com.embarkx.service_reg.controller.Address;
import com.embarkx.service_reg.controller.SampleClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegApplication {

	public static void main(String[] args) {



		SpringApplication.run(ServiceRegApplication.class, args);

		Address address = new Address("abc","abc",123455L);
		SampleClass sampleClass = new SampleClass(1,"manoj","dev",12345L,address);

		sampleClass.getAddress().setAddress1("xyz");
		System.out.println(sampleClass.getAddress().getAddress1());

	}

}
