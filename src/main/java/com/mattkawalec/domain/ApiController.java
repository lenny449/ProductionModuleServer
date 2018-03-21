package com.mattkawalec.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@Autowired
	private ApiService apiService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/add_product")
	public void addProduct(@RequestBody Product product) {
		apiService.addProduct(product);
	}
	
	@RequestMapping("/products/getall")
	public List<Product> getProducts(){
		return apiService.getProducts();
	}
	
	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable String id)
	{
		return apiService.getProduct(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update_product/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable String id)
	{
		apiService.updateProduct(product, id);
	}

	@RequestMapping("/test")
	public String getBeers(){
		return apiService.test();
	}
	
/*	public void addProduct(@RequestBody Product product) {
		apiService.addProduct(product);
	}*/

}



/*@RestController
public class BeerControler {
	
	@Autowired
	private BeerService beerService;
	
	@RequestMapping("/beers")
	public List<Beer> getBeers(){
		return beerService.getBeers();
	}
	
	
	@RequestMapping("/beer/{name}")
	public Beer getBeer(@PathVariable String name)
	{
		
		return beerService.getBeer(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/beers")
	public void addBeer(@RequestBody Beer beer)
	{
		System.out.println("jestem w POSCIE");
		beerService.addBeer(beer);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/beers/{name}")
	public void editBeer(@RequestBody Beer beer, @PathVariable String name)
	{
		System.out.println("jestem w PUT");
		beerService.editBeer(beer, name);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/beers/{name}")
	public void deleteBeer(@PathVariable String name)
	{
		beerService.deleteBeer(name);
	}
}*/

 