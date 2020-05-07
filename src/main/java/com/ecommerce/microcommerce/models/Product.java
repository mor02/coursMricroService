package com.ecommerce.microcommerce.models;

public class Product {

	private int id;
	
	private String name;
	
	private double prix;

	public Product(int id, String name, double prix) {
		super();
		this.id = id;
		this.name = name;
		this.prix = prix;
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


	
	
}
