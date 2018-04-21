package com.mattkawalec.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Recipe extends ElementOfDatabase  {
	@Id
	String recipeId;
	String fullName;
	String resultProductId;
	double workHours;

	@OneToMany
	@JoinColumn(name="owner_recipe_id")
	List<ProductQuantityPair> recipeList;
	
	public List<Object> getElementsList() {
		List<Object> elementsList = new ArrayList<>();
		elementsList.add(this.recipeId);
		elementsList.add(this.fullName);
		elementsList.add(this.resultProductId);
		elementsList.add(this.workHours);
		return elementsList;
	}
	
	public static String[] getLocalNames() {
		String[] localNames = {"Id", "Nazwa", "Produkt końcowy", "Roboczogodziny"};
		return localNames;
	}
	
	public Recipe() {
		super();
	}

	public Recipe(String recipeId, String fullName, String resultProductId, double workHours,
			List<ProductQuantityPair> receipeList) {
		super();
		this.recipeId = recipeId;
		this.fullName = fullName;
		this.resultProductId = resultProductId;
		this.workHours = workHours;
		this.recipeList = receipeList;
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

	public String getResultProductId() {
		return resultProductId;
	}

	public void setResultProductId(String resultProductId) {
		this.resultProductId = resultProductId;
	}

	public double getWorkHours() {
		return workHours;
	}

	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}

	public List<ProductQuantityPair> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<ProductQuantityPair> recipeList) {
		this.recipeList = recipeList;
	}



	
	
}
