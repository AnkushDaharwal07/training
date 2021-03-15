package ekart.order.dto;

import java.sql.Date;
import java.util.List;

public class PlaceOrderDTO {
	
	OrderDTO orderDTO;
	
	List<ProductsOrderedDTO> productsOrderedDTOs;

	public PlaceOrderDTO() {
		super();
	}

	

	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}

	public List<ProductsOrderedDTO> getProductsOrderedDTOs() {
		return productsOrderedDTOs;
	}

	public void setProductsOrderedDTOs(List<ProductsOrderedDTO> productsOrderedDTOs) {
		this.productsOrderedDTOs = productsOrderedDTOs;
	}
	
	

}
