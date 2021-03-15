package com.infosys.product.dto;

import com.infosys.product.entity.SubscribedProduct;

public class SubscribedProductDTO {
	
	Integer subId;
	Integer buyerId;
	Integer sellerId;
	Integer quantity;
	
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
	
	public SubscribedProductDTO(){
		super();
	}
	
	// Converts Entity into DTO
		public static SubscribedProductDTO valueOf(SubscribedProduct sp) {
			SubscribedProductDTO sProductDTO= new SubscribedProductDTO();
			sProductDTO.setSubId(sp.getSubId());
			sProductDTO.setBuyerId(sp.getBuyerId());
			sProductDTO.setSellerId(sp.getSellerId());
			sProductDTO.setQuantity(sp.getQuantity());
			return sProductDTO;
		}
		@Override
		public String toString() {
			return "SubscribedProductDTO [SubId=" + subId + ", BuyerId=" + buyerId + ", SellerId =" + sellerId  + ", Quantity =" + quantity + "]";
		}

}
