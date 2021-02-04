package com.alvesjefs.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BestbuyConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestbuyConfigurationServerApplication.class, args);
	}

}
