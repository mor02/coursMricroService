package com.ecommerce.microcommerce.ctrls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.models.Product;

@RestController
public class ProductCtrl {

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/products/{id}")
	public Product afficherProduit(@PathVariable int id) {
		return new Product(id, "PC DELL", 3000.00);
	}
	
	@RequestMapping(value = "/products")
	public List<Product> findAll(){
		return productDao.findAll();
	}
	
	@PostMapping(value= "saveProduct")
	public void ajouterProduit(@RequestBody Product prd) {
		productDao.saveProduit(prd);
	}
}
