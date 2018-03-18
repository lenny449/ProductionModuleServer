package com.mattkawalec.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
	
	private List<Product> productList = new ArrayList<>();

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
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
