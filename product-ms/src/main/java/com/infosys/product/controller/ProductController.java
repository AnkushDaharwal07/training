package com.infosys.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.product.dto.ProductDTO;
import com.infosys.product.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;

	// Fetches all plan details
	@GetMapping(value = "/products",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProducts() {
		logger.info("Fetching all products");
		//System.out.println(friendUri);
		return productService.getAllProducts();
	}

	// Fetch plan details of a specific plan
	@GetMapping(value = "/products/{prodId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getSpecificProducts(@PathVariable Integer prodId) {
		logger.info("Fetching details of product {}",prodId);
		return productService.getSpecificProducts(prodId);
	}
	
	@GetMapping(value = "/products/name/{productName}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getSpecificProductsName(@PathVariable String productName) {
		logger.info("Fetching details of product {}",productName);
		return productService.getSpecificProductsName(productName);
	}
	
	@GetMapping(value = "/products/category/{category}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getSpecificCategory(@PathVariable String category) {
		logger.info("Fetching details of product {}",category);
		return productService.getSpecificCategory(category);
	}
	
	
}
