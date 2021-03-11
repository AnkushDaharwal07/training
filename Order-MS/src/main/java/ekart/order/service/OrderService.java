package ekart.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ekart.order.dto.OrderDTO;
import ekart.order.dto.PlaceOrderDTO;
import ekart.order.dto.ProductsOrderedDTO;
import ekart.order.entity.Order;
import ekart.order.entity.ProductsOrdered;
import ekart.order.repository.OrderRepository;
import ekart.order.repository.ProductsOrderedRepository;

@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderDetailsRepo;
	
	@Autowired
	ProductsOrderedRepository productsOrderedRepository;
	
	public void saveOrder(int ORDERID, OrderDTO orderDTO) {
		logger.info("Place Order {} with data {}", ORDERID, orderDTO);
		orderDTO.setORDERID(ORDERID);
		Order order = orderDTO.createOrder();
		orderDetailsRepo.save(order);
	}

	// Find order by ID
	public PlaceOrderDTO getOrder( int ORDERID) {

		logger.info("Order {}", ORDERID);
		
		PlaceOrderDTO placeOrderDTO=null;
		
		OrderDTO orderDTO=null;
		
		List<ProductsOrderedDTO> productsOrderedDTOs=null;
		
		Optional<Order> optOrder = orderDetailsRepo.findById(ORDERID);
		if (optOrder.isPresent()) {
			Order order = optOrder.get();
			orderDTO = OrderDTO.valueOf(order);
		}
		
		List<ProductsOrdered> productsOrdereds=productsOrderedRepository.getByORDERID(ORDERID);
		for(ProductsOrdered productsOrdered:productsOrdereds){
			productsOrderedDTOs.add(ProductsOrderedDTO.valueOf(productsOrdered));
		}
		
		placeOrderDTO.setOrderDTO(orderDTO);
		placeOrderDTO.setProductsOrderedDTOs(productsOrderedDTOs);
		return placeOrderDTO;
	}
}
