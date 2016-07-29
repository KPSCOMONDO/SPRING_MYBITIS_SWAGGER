package com.spring.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.spring"})
public class KspChannySpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(KspChannySpringJdbcApplication.class, args);
	}
}
