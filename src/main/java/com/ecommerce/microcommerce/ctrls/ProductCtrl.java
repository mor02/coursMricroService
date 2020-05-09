package com.ecommerce.microcommerce.ctrls;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.models.Product;

@RestController
public class ProductCtrl {

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/products/{id}")
	public Product afficherProduit(@PathVariable int id) {
		return productDao.findProductById(id);
	}
	
	@RequestMapping(value = "/products")
	public List<Product> findAll(){
		return productDao.findAll();
	}
	
	@PostMapping(value= "/products")
	public ResponseEntity<Object> ajouterProduit(@RequestBody Product prd) {
		Product prd1 = productDao.saveProduit(prd);
		if(prd1==null) {
			return ResponseEntity.noContent().build();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prd1.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
			
}
