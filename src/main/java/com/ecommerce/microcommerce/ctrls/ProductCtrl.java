package com.ecommerce.microcommerce.ctrls;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.exceptions.ProductNotFoundException;
import com.ecommerce.microcommerce.models.Product;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class ProductCtrl {

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/products/{id}")
	public Product afficherProduit(@PathVariable int id) {
//		SimpleBeanPropertyFilter monFilter = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
//
//		
//		FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("filtreProduct", monFilter);
//		
//		
//		MappingJacksonValue produitsFiltres = new MappingJacksonValue(productDao.findProductById(id));
//		
//		produitsFiltres.setFilters(listDeNosFiltres);
//		
//		return produitsFiltres;
		Product p=  productDao.findById(id);
		if(p==null) {
			throw new ProductNotFoundException("L'artile " + id + " n'existe pas !");
		}
		return p;
	}
	
	
	@RequestMapping(value = "/products/criteres/{limit}")
	public List<Product> afficherProduitByCriteres(@PathVariable double limit) {
		List<Product> products = productDao.findByPrixGreaterThan(limit);

		if (products == null || products.isEmpty()) {
			throw new ProductNotFoundException("Aucun article ne correspond à ces critères");
		}
		return products;

	}
	
	@RequestMapping(value = "/products")
	public List<Product> findAll() {
		
		List<Product> products = productDao.findAll();
//		SimpleBeanPropertyFilter monFilter = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
//
//		FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("filtreProduct", monFilter);
//
//		MappingJacksonValue produitsFiltres = new MappingJacksonValue(products);
//
//		produitsFiltres.setFilters(listDeNosFiltres);
		if(products == null || products.isEmpty()) {
			throw new ProductNotFoundException("Aucun article ne correspond à ces critères");
		}
		return products;
	}
	
	@PostMapping(value= "/products")
	public ResponseEntity<Object> ajouterProduit(@RequestBody Product prd) {
		Product prd1 = productDao.save(prd);
		if(prd1==null) {
			return ResponseEntity.noContent().build();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prd1.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
			
}
