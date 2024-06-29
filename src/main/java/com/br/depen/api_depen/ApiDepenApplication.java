package com.br.depen.api_depen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan(basePackages = "com.br.depen.api_depen.entities")
@ComponentScan(basePackages = "com.br.depen.api_depen")
public class ApiDepenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDepenApplication.class, args);
	}

}
