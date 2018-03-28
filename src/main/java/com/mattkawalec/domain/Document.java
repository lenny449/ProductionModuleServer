package com.mattkawalec.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Document {
	@Id
	String documentId;
	
	@OneToMany
	List<ProductQuantityPair> receipeList;
	
	public Document() {
		super();
	}


	
}
