package com.infosys.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infosys.product.dto.ProductDTO;
import com.infosys.product.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;
	@Autowired
	Environment environment;

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
	//add product by Ankush
	@PostMapping(value = "/products",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createProduct(@RequestBody ProductDTO productDTO) {
		logger.info("Creation request for product {}", productDTO);
		productService.createProduct(productDTO);
	}
	
	// remove product @ankush
	//deactivate seller
	@DeleteMapping(value = "/product/{prodId}")
    public ResponseEntity<Boolean> removeProduct(@PathVariable Integer prodId) {
		try {
			logger.info("delete product request from seller for productid{}",prodId);
			Boolean check=productService.removeProduct(prodId);
			return new ResponseEntity<Boolean>(check,HttpStatus.FOUND);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
		}
        
    }
	@PutMapping(value = "/product/updatestocks" ,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateStocks(@RequestBody ProductDTO productDTO) {
		try {
			logger.info("update stock request from seller for productId{}",productDTO.getProdId());
			Boolean check=productService.updateStock(productDTO);
			return new ResponseEntity<Boolean>(check,HttpStatus.FOUND);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
		}
        
    }
	
	@PutMapping(value = "/product/updateStatus" ,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> changeStatus(@RequestBody ProductDTO productDTO) {
		try {
			logger.info("update status request from seller for productId{}",productDTO.getProdId());
			Boolean check=productService.changeStatus(productDTO);
			return new ResponseEntity<Boolean>(check,HttpStatus.FOUND);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
		}
        
    }
	
}
