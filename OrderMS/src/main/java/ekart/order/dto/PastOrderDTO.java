package ekart.order.dto;

import java.util.List;

import ekart.order.entity.PastOrder;

public class PastOrderDTO{
	private Integer buyerId;
	private Integer  orderId;
	private String status;
	List<ProductsOrderedDTO> productsOrderedDTOs;
	public PastOrderDTO(Integer buyerId, Integer orderId, String status) {
		super();
		this.buyerId = buyerId;
		this.orderId = orderId;
		this.status = status;
	}
	public List<ProductsOrderedDTO> getProductsOrderedDTOs() {
		return productsOrderedDTOs;
	}
	public void setProductsOrderedDTOs(List<ProductsOrderedDTO> productsOrderedDTOs) {
		this.productsOrderedDTOs = productsOrderedDTOs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String toString() {
		return "PastOrderDTO [buyerId=" + buyerId + ", orderId=" + orderId + ", status=" + status + "]";
	}

	public PastOrderDTO() {
		super();
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
		PastOrderDTO other = (PastOrderDTO) obj;
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
	
	public static PastOrderDTO valueOf(PastOrder pastOrder) {
		PastOrderDTO pastOrderDTO = new PastOrderDTO();
		pastOrderDTO.setBuyerId(pastOrder.getBuyerId());
		pastOrderDTO.setOrderId(pastOrder.getOrderId());
		pastOrderDTO.setStatus(pastOrder.getStatus());
		pastOrderDTO.setProductsOrderedDTOs(pastOrder.getProductsOrderedDTOs());
		return pastOrderDTO;

	}
	public PastOrder createEntity() {
		PastOrder pastOrder = new PastOrder();
		pastOrder.setBuyerId(this.getBuyerId());
		pastOrder.setOrderId(this.getOrderId());
		pastOrder.setStatus(this.getStatus());
		pastOrder.setProductsOrderedDTOs(this.getProductsOrderedDTOs());


		return pastOrder;
	}
	
}
