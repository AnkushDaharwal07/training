package com.infosys.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.infosys.product.dto.ProductDTO;
import com.infosys.product.entity.Product;
import com.infosys.product.repository.ProductRepository;


@Service
public class ProductService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepository productRepo;
	

	// Fetches all product details
	public List<ProductDTO> getAllProducts() {

		List<Product> products = productRepo.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();

		for (Product product : products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}

		logger.info("Product details : {}", productDTOs);
		return productDTOs;
	}
	
	// Fetch specific product details by Product ID
	public ProductDTO getSpecificProducts(int productId) {
		ProductDTO productDTO = null;
		Optional<Product> optProduct = productRepo.findById(productId);
		if (optProduct.isPresent()) {
			Product product = optProduct.get();
			productDTO = ProductDTO.valueOf(product);
		}
		logger.info("Product details : {}", productId);
		return productDTO;

	}
	
	// Fetch specific product details by Product Name
	public List<ProductDTO> getSpecificProductsName(String productName) {

		List<Product> products = productRepo.findByProductName(productName);
		List<ProductDTO> productDTOs = new ArrayList<>();

		for (Product product : products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}

		logger.info("Product details : {}", productName);
		return productDTOs;
	}
	
	// Fetch specific product details by category
		public List<ProductDTO> getSpecificCategory(String category) {

			List<Product> products = productRepo.findByCategory(category);
			List<ProductDTO> productDTOs = new ArrayList<>();

			for (Product product : products) {
				ProductDTO productDTO = ProductDTO.valueOf(product);
				productDTOs.add(productDTO);
			}

			logger.info("Product details : {}", category);
			return productDTOs;
		}

		public void createProduct(ProductDTO productDTO) {			
			logger.info("Creation product by seller {}", productDTO);
			Product product = productDTO.createEntity();
			productRepo.save(product);		
		}
		
		
		public boolean removeProduct(Integer prodId) {
			logger.info("remove product request from seller for productId{}", prodId);
			Optional<Product> optProduct =productRepo.findById(prodId);
			if(optProduct.isPresent()) {
				productRepo.deleteById(prodId);
				return true;
			}
			else {
				return false;
			}
			
		}

		public boolean updateStock(ProductDTO productDTO) {
			logger.info("update stock request from seller for productId{}", productDTO.getProdId());
			Optional<Product> optProduct =productRepo.findById(productDTO.getProdId());
			Product product = productDTO.createEntity();
			if(optProduct.isPresent()) {
				productRepo.save(product);
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean changeStatus(ProductDTO productDTO) {
			logger.info("update status request from seller for productId{}", productDTO.getProdId());
			Optional<Product> optProduct =productRepo.findById(productDTO.getProdId());
			Product product = productDTO.createEntity();
			if(optProduct.isPresent()) {
				productRepo.save(product);
				return true;
			}
			else {
				return false;
			}
		}
	
	
}
