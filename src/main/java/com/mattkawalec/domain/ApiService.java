package com.mattkawalec.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	
	@Autowired
	DatabaseConnection databaseConnection;
	
	private List<Product> productList = new ArrayList<>();
	
	// Function connected with Product Objects

	public void addProduct(Product product) {
		databaseConnection.entityManager.getTransaction().begin();
		databaseConnection.entityManager.persist(product);
		databaseConnection.entityManager.getTransaction().commit();
	}
	
	public void deleteProduct(String id) {
		Product tempProduct;
		databaseConnection.entityManager.getTransaction().begin();
		tempProduct = databaseConnection.entityManager.find(Product.class, id);
		databaseConnection.entityManager.remove(tempProduct);		
		databaseConnection.entityManager.getTransaction().commit();	
	}
	
	public Product getProduct(String id) {
		Product tempProduct;
		databaseConnection.entityManager.getTransaction().begin();
		tempProduct = databaseConnection.entityManager.find(Product.class, id);
		databaseConnection.entityManager.getTransaction().commit();
		return tempProduct;
	}

	public List<Product> getAllProducts() {
		TypedQuery<Product> query = databaseConnection.entityManager.createQuery("select e from Product e", Product.class);
		T.t("przeszedlem funkcje query");
		List<Product> productsList = query.getResultList();
		return productsList;
	}
	
	public void updateProduct(Product product, String id) {
		Product tempProduct;
		databaseConnection.entityManager.getTransaction().begin();
		tempProduct = databaseConnection.entityManager.find(Product.class, id);
		databaseConnection.entityManager.remove(tempProduct);
		databaseConnection.entityManager.persist(product);
		
		databaseConnection.entityManager.getTransaction().commit();		
	}


	
	// Function connected with Recipe Objects

	public void addRecipe(Recipe recipe) {
		databaseConnection.entityManager.getTransaction().begin();
		databaseConnection.entityManager.persist(recipe);
		for(ProductQuantityPair pair : recipe.receipeList) {
			databaseConnection.entityManager.persist(pair);
		}
		databaseConnection.entityManager.getTransaction().commit();	
	}

	public void deleteRecipe(String id) {
		Recipe tempRecipe;
		databaseConnection.entityManager.getTransaction().begin();
		tempRecipe = databaseConnection.entityManager.find(Recipe.class, id);
		databaseConnection.entityManager.remove(tempRecipe);		
		databaseConnection.entityManager.getTransaction().commit();	
	}

	public List<Recipe> getAllRecipe() {
		TypedQuery<Recipe> query = databaseConnection.entityManager.createQuery("select e from Recipe e", Recipe.class);
		T.t("przeszedlem funkcje query");
		List<Recipe> recipeList = query.getResultList();
		return recipeList;
	}

	
	public Recipe getRecipe(String id) {
		Recipe tempRecipe;
		databaseConnection.entityManager.getTransaction().begin();
		tempRecipe = databaseConnection.entityManager.find(Recipe.class, id);
		databaseConnection.entityManager.getTransaction().commit();
		return tempRecipe;
	}

	public String test() {	
		
/*		Product p1 = new Product("LCH", "Lech", 4.0, 3.0);
		ProductQuantityPair pair2 = new ProductQuantityPair("LE1", 13.0);
		ProductQuantityPair pair3 = new ProductQuantityPair("ZE1", 13.0);
		List<ProductQuantityPair> lista = new ArrayList<>();
		lista.add(pair2);
		lista.add(pair3);
		Recipe r1 = new Recipe("RECEP3", "receptura na bimber3", 4.4, p1, lista);
		databaseConnection.entityManager.getTransaction().begin();
		databaseConnection.entityManager.persist(p1);
		databaseConnection.entityManager.persist(pair2);
		databaseConnection.entityManager.persist(pair3);
		databaseConnection.entityManager.persist(r1);
		databaseConnection.entityManager.getTransaction().commit();*/		
		return null;
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
