package com.ecommerce.microcommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.models.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	public List<Product> findAll();
	public Product findById(int id);
	@SuppressWarnings("unchecked")
	public Product save(Product prd);
	
	public List<Product> findByPrixGreaterThan(double limit);
	
	//ça existe mais à éviter pour éviter le couplage avec une BDD
//	@Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
//	   List<Product>  chercherUnProduitCher(@Param("prixLimit") int prix);
}
