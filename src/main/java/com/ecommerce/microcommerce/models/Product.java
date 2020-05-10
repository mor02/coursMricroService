package com.ecommerce.microcommerce.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties(value="id")
@JsonFilter("filtreProduct")
public class Product {

	//@JsonIgnore
	private int id;
	
	private String name;
	
	private double prix;
	
	private double prixAchat;

	
	
	public Product(int id, String name, double prix, double prixAchat) {
		super();
		this.id = id;
		this.name = name;
		this.prix = prix;
		this.prixAchat = prixAchat;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}


	
	
	
}
