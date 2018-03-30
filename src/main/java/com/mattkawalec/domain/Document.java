package com.mattkawalec.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Document {
	public enum TypeOfTransaction {RW, PW, WZ, PZ};
	
	@Id
	String documentId;
	String description;
	TypeOfTransaction typeOfTransaction;
	
	@OneToMany
	List<ProductQuantityPair> recipeList;	
	
	public Document() {
		super();
	}
	
}
