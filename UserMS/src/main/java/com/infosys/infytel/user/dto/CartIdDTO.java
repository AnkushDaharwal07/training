package com.infosys.infytel.user.dto;

import com.infosys.infytel.user.entity.CartId;

public class CartIdDTO {

	private Integer buyerId;
	private Integer productId;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "CartDTO [buyerId=" + buyerId + ", productId=" + productId + "]";
	}
	public static CartIdDTO valueOf(CartId cartId) {
		CartIdDTO cartDTO = new CartIdDTO();
		cartDTO.setBuyerId(cartId.getBuyerId());
		cartDTO.setProductId(cartId.getProductId());
		return cartDTO;

	}
	public CartId createEntity() {
		CartId cartId = new CartId();
		cartId.setBuyerId(this.getBuyerId());
		cartId.setProductId(this.getProductId());


		return cartId;
	}

}