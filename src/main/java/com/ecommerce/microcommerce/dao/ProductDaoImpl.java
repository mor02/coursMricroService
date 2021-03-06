package com.ecommerce.microcommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.models.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	static List<Product> listeProducts;
	static {
		Product p1 = new Product(1, "PC DELL", 3000);
		Product p2 = new Product(2, "Aspirateur", 2000);
		Product p3 = new Product(3, "Machine à laver", 4000);
		listeProducts = new ArrayList<Product>();
		listeProducts.add(p1);
		listeProducts.add(p2);
		listeProducts.add(p3);
	}
	@Override
	public List<Product> findAll() {
		return listeProducts;
	}

	
}
