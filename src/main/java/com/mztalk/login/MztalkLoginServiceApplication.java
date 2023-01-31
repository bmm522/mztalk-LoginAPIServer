package com.mztalk.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MztalkLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MztalkLoginServiceApplication.class, args);
	}

}