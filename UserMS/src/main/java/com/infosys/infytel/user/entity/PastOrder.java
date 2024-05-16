package com.infosys.infytel.user.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;


@SuppressWarnings("serial")
@Embeddable
public class PastOrder implements Serializable {
    
	
	private Integer buyerId;

	private Integer orderId;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyerId == null) ? 0 : buyerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		PastOrder other = (PastOrder) obj;
		if (buyerId == null) {
			if (other.buyerId != null)
				return false;
		} else if (!buyerId.equals(other.buyerId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PastOrder [buyerId=" + buyerId + ", orderId=" + orderId + "]";
	}
	
	
	
	
}