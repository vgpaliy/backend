package com.youtube.server.scgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ScgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScgatewayApplication.class, args);
	}

}
