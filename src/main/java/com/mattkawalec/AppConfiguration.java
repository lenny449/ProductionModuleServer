package com.mattkawalec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mattkawalec.domain.DatabaseConnection;

@Configuration
public class AppConfiguration {
	@Bean
	public DatabaseConnection databaseConnection() {
		return new DatabaseConnection();
	}
}
