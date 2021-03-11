package com.infosys.product.dto;

import com.infosys.product.entity.Product;

public class ProductDTO {

	
	Integer prodId;
	String brand;
	String category;
	String description;
	String image;
	double price;
	String productName;
	Integer rating;
	Integer stock;
	Integer sellerId;
	String subcategory;
	
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSubCategory() {
		return subcategory;
	}
	public void setSubCategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}

	
	public ProductDTO() {
		super();
	}

	// Converts Entity into DTO
	public static ProductDTO valueOf(Product product) {
		ProductDTO productDTO= new ProductDTO();
		productDTO.setProdId(product.getProdId());
		productDTO.setBrand(product.getBrand());
		productDTO.setCategory(product.getCategory());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());
		productDTO.setProductName(product.getProductName());
		productDTO.setRating(product.getRating());
		productDTO.setSellerId(product.getSellerId());
		productDTO.setStock(product.getStock());
		productDTO.setSubCategory(product.getSubCategory());
		return productDTO;
	}
	@Override
	public String toString() {
		return "ProductDTO [prodId=" + prodId + ", Brand=" + brand + ", productname =" + productName + "]";
	}


}
