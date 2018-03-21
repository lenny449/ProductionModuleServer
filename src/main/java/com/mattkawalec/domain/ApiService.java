package com.mattkawalec.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	
	@Autowired
	DatabaseConnection databaseConnection;
	
	private List<Product> productList = new ArrayList<>();

	public void addProduct(Product product) {
		databaseConnection.entityManager.getTransaction().begin();
		databaseConnection.entityManager.persist(product);
		databaseConnection.entityManager.getTransaction().commit();
	}
	
	public Product getProduct(String id) {
		Product tempProduct;
		databaseConnection.entityManager.getTransaction().begin();
		tempProduct = databaseConnection.entityManager.find(Product.class, id);
		databaseConnection.entityManager.getTransaction().commit();
		return tempProduct;
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateProduct(Product product, String id) {
		Product tempProduct;
		databaseConnection.entityManager.getTransaction().begin();
		tempProduct = databaseConnection.entityManager.find(Product.class, id);
		T.t("jestem w update product");
		//tempProduct = product;
		tempProduct.setPrice(10.0);
		databaseConnection.entityManager.getTransaction().commit();		
	}

	public String test() {	
		databaseConnection.entityManager.getTransaction().begin();
		databaseConnection.entityManager.persist(new Product("LE5", "Lezajsk5", 1.0, 2.8));
		databaseConnection.entityManager.getTransaction().commit();
		return "test przepriowadzony";
	}



	

}

/*package com.lennyproject.beer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BeerService {
	private List<Beer> beerList = new ArrayList<>(
			Arrays.asList(new Beer("Lezajsk", "czerwony"), new Beer("Zywiec", "zielony"), new Beer("Tatra", "czarna")));

	public List<Beer> getBeers() {
		return beerList;
	}

	
	 * public Beer getBeer(Str ing s) { return beerList.stream().filter(t ->
	 * t.getName().equals(s)).findFirst().get(); }
	 

	public Beer getBeer(String s) {
		// return new Beer(s, "kolorowe");
		return beerList.stream().filter(t -> t.getName().equals(s)).findFirst().get();
	}

	public void addBeer(Beer beer) {
		beerList.add(beer);
		System.out.println("dodaje piwo");
	}

	public void editBeer(Beer beer, String name) {
		for (int i = 0 ; i < beerList.size(); i++ ) {
			Beer tempBeer = beerList.get(i);
			if(tempBeer.getName().equals(name)) {
				System.out.println("znalazlem tego bronksa");
				beerList.set(i, beer);
			}

			
		}
	}

	public void deleteBeer(String name) {
		beerList.removeIf(t -> t.getName().equals(name));
		
	}

}*/
