package com.qa.DBCon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DbConApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbConApplication.class, args);
	}
}
