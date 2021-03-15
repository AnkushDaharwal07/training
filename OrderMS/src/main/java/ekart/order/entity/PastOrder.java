package ekart.order.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;

import ekart.order.dto.ProductsOrderedDTO;


@SuppressWarnings("serial")
@Embeddable
public class PastOrder implements Serializable {
    
	
	private Integer buyerId;
	private List<ProductsOrderedDTO> productsOrderedDTOs;


	private Integer orderId;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public List<ProductsOrderedDTO> getProductsOrderedDTOs() {
		return productsOrderedDTOs;
	}

	public void setProductsOrderedDTOs(List<ProductsOrderedDTO> productsOrderedDTOs) {
		this.productsOrderedDTOs = productsOrderedDTOs;
	}
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
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PastOrder [buyerId=" + buyerId + ", orderId=" + orderId + ", status=" + status + "]";
	}

	public PastOrder() {
		super();
	}

	public PastOrder(Integer buyerId, Integer orderId, String status) {
		super();
		this.buyerId = buyerId;
		this.orderId = orderId;
		this.status = status;
	}
	
	
	
	
}