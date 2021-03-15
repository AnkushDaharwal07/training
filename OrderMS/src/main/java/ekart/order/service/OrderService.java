package ekart.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ekart.order.dto.MyKeyDTO;
import ekart.order.dto.OrderDTO;
import ekart.order.dto.PlaceOrderDTO;
import ekart.order.dto.ProductsOrderedDTO;
import ekart.order.entity.MyKey;
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
	
	
	public void saveOrder(OrderDTO orderDTO) {
		logger.info("Place Order {} with data {}", orderDTO);
		Order order = orderDTO.createOrder();
		orderDetailsRepo.save(order);
	}

	// Find order by ID
	public PlaceOrderDTO getOrder( int ORDERID) {

		logger.info("Order {}", ORDERID);
		

		
		PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO();
		
		OrderDTO orderDTO=new OrderDTO();
		
		List<ProductsOrderedDTO> productsOrderedDTOs=new ArrayList<ProductsOrderedDTO>();
		
		Optional<Order> optOrder = orderDetailsRepo.findById(ORDERID);
		if (optOrder.isPresent()) {
			Order order = optOrder.get();
			orderDTO = OrderDTO.valueOf(order);
		}
		List<ProductsOrdered> productsOrdereds=productsOrderedRepository.findByORDERID(ORDERID);
		for(ProductsOrdered productsOrdered:productsOrdereds){
			productsOrderedDTOs.add(ProductsOrderedDTO.valueOf(productsOrdered));
		}
		
//		Optional<ProductsOrdered> productsOrdereds=productsOrderedRepository.findById(optMyKey);
//		for(ProductsOrdered productsOrdered:productsOrdereds){
//			productsOrderedDTOs.add(ProductsOrderedDTO.valueOf(productsOrdered));
//		}
		
		placeOrderDTO.setOrderDTO(orderDTO);
		placeOrderDTO.setProductsOrderedDTOs(productsOrderedDTOs);
		return placeOrderDTO;
	}
	
	public OrderDTO getOrder1( int ORDERID) {

		logger.info("Order {}", ORDERID);
		
		
		OrderDTO orderDTO=null;
		
		
		Optional<Order> optOrder = orderDetailsRepo.findById(ORDERID);
		if (optOrder.isPresent()) {
			Order order = optOrder.get();
			orderDTO = OrderDTO.valueOf(order);
		}
		
		return orderDTO;
	}
}
