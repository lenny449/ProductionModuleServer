package com.mattkawalec.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Recipe {
	@Id
	String recipeId;
	String fullName;
	
	double workHours;
	
	//@Embedded
	//Product3 p3;
	
	@OneToMany
	List<ProductQuantityPair> receipeList;
	
	public Recipe() {
		super();
	}

	public Recipe(String recipeId, String fullName, String resultProductId, double workHours,
			List<ProductQuantityPair> receipeList) {
		super();
		this.recipeId = recipeId;
		this.fullName = fullName;
		this.workHours = workHours;
		this.receipeList = receipeList;
	}

	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getWorkHours() {
		return workHours;
	}

	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}

	public List<ProductQuantityPair> getReceipeList() {
		return receipeList;
	}

	public void setReceipeList(List<ProductQuantityPair> receipeList) {
		this.receipeList = receipeList;
	}

	
	
}
