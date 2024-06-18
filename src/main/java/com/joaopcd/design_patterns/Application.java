package com.joaopcd.design_patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.joaopcd.design_patterns")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
