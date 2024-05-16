package com.infosys.infytel.user.dto;


import com.infosys.infytel.user.entity.PastOrder;

public class PastOrderDTO{
	private Integer buyerId;
	private Integer  orderId;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "PastOrder [buyerId=" + buyerId + ", orderId=" + orderId + "]";
	}
	public PastOrderDTO(Integer buyerId, Integer orderId) {
		super();
		this.buyerId = buyerId;
		this.orderId = orderId;
	}
	public PastOrderDTO() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((buyerId == null) ? 0 : buyerId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PastOrderDTO other = (PastOrderDTO) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (buyerId == null) {
			if (other.buyerId != null)
				return false;
		} else if (!buyerId.equals(other.buyerId))
			return false;
		return true;
	}
	
	public static PastOrderDTO valueOf(PastOrder pastOrder) {
		PastOrderDTO pastOrderDTO = new PastOrderDTO();
		pastOrderDTO.setBuyerId(pastOrder.getBuyerId());
		pastOrderDTO.setOrderId(pastOrder.getOrderId());
		return pastOrderDTO;

	}
	public PastOrder createEntity() {
		PastOrder pastOrder = new PastOrder();
		pastOrder.setBuyerId(this.getBuyerId());
		pastOrder.setOrderId(this.getOrderId());


		return pastOrder;
	}
	
}
