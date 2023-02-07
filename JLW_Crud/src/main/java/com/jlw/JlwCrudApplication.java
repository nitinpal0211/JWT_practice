package com.jlw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class JlwCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JlwCrudApplication.class, args);
	}

}
