package com.ecommerce.microcommerce.dao;

import java.util.List;

import com.ecommerce.microcommerce.models.Product;

public interface ProductDao {

	public List<Product> findAll();
	public void saveProduit(Product prd);
}
