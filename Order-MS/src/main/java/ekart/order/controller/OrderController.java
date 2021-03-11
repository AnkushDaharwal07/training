package ekart.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import ekart.order.dto.OrderDTO;
import ekart.order.dto.PlaceOrderDTO;
import ekart.order.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderService orderService;
	
	@PostMapping(value = "/orders/placeorder/{ORDERID}",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveOrder(@PathVariable int ORDERID, @RequestBody OrderDTO orderDTO) {
		logger.info("Creation request for Order {} with ID {}", ORDERID, orderDTO);
		orderService.saveOrder(ORDERID, orderDTO);
	}

	// Fetches call details of a specific customer
	@GetMapping(value = "/orders/{ORDERID}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public PlaceOrderDTO getOrderDetails(@PathVariable int ORDERID) {

		logger.info("OrderDetails {}", ORDERID);

		return orderService.getOrder(ORDERID);
	}

}
