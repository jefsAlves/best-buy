package com.alvesjefs.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BestbuyEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestbuyEurekaServerApplication.class, args);
	}

}
