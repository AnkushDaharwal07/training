package com.infosys.product.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findAll();


	List<Product> findByProductName(String productName);


	List<Product> findByCategory(String category);	
	

}

