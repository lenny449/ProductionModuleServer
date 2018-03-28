package com.mattkawalec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductQuantityPair {
	
	@Id
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
