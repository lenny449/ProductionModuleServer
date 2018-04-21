package com.mattkawalec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductQuantityPair {
	
	@Id
	@GeneratedValue
	long id;
	String pairedProductName;
	double pairedQuantity;
	
	public ProductQuantityPair() {
		super();
	}

	public ProductQuantityPair(String pairedProductName, double pairedQuantity) {
		super();
		this.pairedProductName = pairedProductName;
		this.pairedQuantity = pairedQuantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPairedProductName() {
		return pairedProductName;
	}

	public void setPairedProductName(String pairedProductName) {
		this.pairedProductName = pairedProductName;
	}

	public double getPairedQuantity() {
		return pairedQuantity;
	}

	public void setPairedQuantity(double pairedQuantity) {
		this.pairedQuantity = pairedQuantity;
	}


}
