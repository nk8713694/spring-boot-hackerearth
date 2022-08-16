package com.verifone.springbootverifone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableTransactionManagement
public class SpringbootVerifoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootVerifoneApplication.class, args);
	}

}
