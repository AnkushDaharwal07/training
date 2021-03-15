package com.infosys.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubscribedProduct {
	public Integer getSubId() {
		return subId;
	}
	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Id
	@Column(name = "SUBID", nullable = false)
	Integer subId;
	@Column(name = "BUYERID", nullable = false)
	Integer buyerId;
	@Column(name = "SELLERID", nullable = false)
	Integer sellerId;
	@Column(name = "QUANTITY", nullable = false)
	Integer quantity;
	
	
}
