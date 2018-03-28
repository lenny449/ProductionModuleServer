package com.mattkawalec;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mattkawalec.domain.DatabaseConnection;
import com.mattkawalec.domain.Product;
import com.mattkawalec.domain.T;

@SpringBootApplication
public class ProductionModuleServerApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductionModuleServerApp.class, args);
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		context.registerShutdownHook();
		
		//context.close();
		//DatabaseConnection databaseConnection = context.getBean(DatabaseConnection.class);		
		T.t("chyba dziala");		
	}
	
}