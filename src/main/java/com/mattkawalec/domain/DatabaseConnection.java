package com.mattkawalec.domain;

import java.util.logging.Logger;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

// Service responsible for connection with database

@Service
public class DatabaseConnection {
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	private Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
	
	public DatabaseConnection() {
		super();
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		T.t("tworzę obiekt database connection");
	}
	
	@PreDestroy
	public void preDestroy() {
		entityManager.close(); 
		entityManagerFactory.close();
	}
}
