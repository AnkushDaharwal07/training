package com.infosys.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@Column(name = "PRODID", nullable = false)
	Integer prodId;
	@Column(name = "RATING", nullable = false)
	Integer rating;
	@Column(name = "SELLERID", nullable = false)
	Integer sellerId;
	@Column(name = "STOCK", nullable = false)
	Integer stock;
	@Column(name = "PRICE", nullable = false)
	double price;
	@Column(name = "PRODUCTNAME", nullable = false, length = 255)
	String productName;
	@Column(name = "BRAND", nullable = false, length = 255)
	String brand;
	@Column(name = "CATEGORY", nullable = false, length = 255)
	String category;
	@Column(name = "SUBCATEGORY", nullable = false, length = 255)
	String subcategory;
	@Column(name = "DESCRIPTION", nullable = false, length = 255)
	String description;
	@Column(name = "IMAGE", nullable = false, length = 255)
	String image;
	
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

	public Product() {
		super();
	}

	
}
