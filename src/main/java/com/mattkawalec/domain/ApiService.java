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

import com.mattkawalec.domain.Document.TypeOfTransaction;

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
		for(ProductQuantityPair pair : recipe.getRecipeList()) {
			databaseConnection.entityManager.persist(pair);
		}
		
		databaseConnection.entityManager.getTransaction().commit();	
		T.t("lemon");
		
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
		T.t("przeszedlem funkcje query w getAllRecipe");
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
	
	public void updateRecipe(Recipe recipe, String id) {
		Recipe tempRecipe;
		databaseConnection.entityManager.getTransaction().begin();
		tempRecipe = databaseConnection.entityManager.find(Recipe.class, id);
		databaseConnection.entityManager.remove(tempRecipe);
		databaseConnection.entityManager.persist(recipe);		
		databaseConnection.entityManager.getTransaction().commit();	
	}
	
	// Function connected with Document Objects

	public void addDocument(Document document) {
		databaseConnection.entityManager.getTransaction().begin();
		databaseConnection.entityManager.persist(document);
		for(ProductQuantityPair pair : document.getRecipeList()) {
			databaseConnection.entityManager.persist(pair);
		}
		databaseConnection.entityManager.getTransaction().commit();	
	}

	public void deleteDocument(String id) {
		Document tempDocument;
		databaseConnection.entityManager.getTransaction().begin();
		tempDocument = databaseConnection.entityManager.find(Document.class, id);
		databaseConnection.entityManager.remove(tempDocument);		
		databaseConnection.entityManager.getTransaction().commit();	
	}

	public List<Document> getAllDocuments() {
		TypedQuery<Document> query = databaseConnection.entityManager.createQuery("select e from Document e", Document.class);
		List<Document> documentList = query.getResultList();
		return documentList;
	}

	
	public Document getDocument(String id) {
		Document tempDocument;
		databaseConnection.entityManager.getTransaction().begin();
		tempDocument = databaseConnection.entityManager.find(Document.class, id);
		databaseConnection.entityManager.getTransaction().commit();
		return tempDocument;
	}
	
	public void updateDocument(Document document, String id) {
		Document tempDocument;
		databaseConnection.entityManager.getTransaction().begin();
		tempDocument = databaseConnection.entityManager.find(Document.class, id);
		databaseConnection.entityManager.remove(tempDocument);
		databaseConnection.entityManager.persist(document);		
		databaseConnection.entityManager.getTransaction().commit();	
	}

	public String test() {	
		ProductQuantityPair pqp1 = new ProductQuantityPair("TA", 7.0);
		ProductQuantityPair pqp2 = new ProductQuantityPair("LE", 3.0);
		List<ProductQuantityPair> listaPQP = new ArrayList<ProductQuantityPair>();
		listaPQP.add(pqp1);
		listaPQP.add(pqp2);
		
		TypeOfTransaction tot = Document.TypeOfTransaction.RW;
		
		Recipe r1 = new Recipe("B12", "bimbrowanie", "BIMP1201", 4, listaPQP);
		Document d1 = new Document("FS-52", "faktura", "2018-01-19", tot, listaPQP);
		T.t("jestem w tescie");
		
		addDocument(d1);
		//addRecipe(r1);
		/*databaseConnection.entityManager.getTransaction().begin();
		databaseConnection.entityManager.persist(r1);
		databaseConnection.entityManager.persist(pqp1);
		databaseConnection.entityManager.persist(pqp2);
		databaseConnection.entityManager.getTransaction().commit();	*/
	
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
