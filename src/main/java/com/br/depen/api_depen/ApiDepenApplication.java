package com.br.depen.api_depen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan(basePackages = "com.br.depen.api_depen.entities")
public class ApiDepenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDepenApplication.class, args);
	}

}
