package com.mattkawalec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	//@GeneratedValue
	private String productId;
	private String fullName;
	private double quantity;
	private double price;
	
	public Product() {
		super();
	}

	public Product(String fullName, double quantity, double price) {
		super();
		this.fullName = fullName;
		this.quantity = quantity;
		this.price = price;
	}

	public Product(String productId, String fullName, double quantity, double price) {
		super();
		this.productId = productId;
		this.fullName = fullName;
		this.quantity = quantity;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
