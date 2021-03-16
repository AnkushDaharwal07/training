package ekart.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Optional;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ekart.order.dto.OrderDTO;
import ekart.order.entity.Order;
import ekart.order.repository.OrderRepository;
import ekart.order.service.OrderService;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	private  OrderService orderService;
	
	@Mock
	OrderRepository orderRepository;
	
	@InjectMocks
	OrderService orderMockService=new OrderService();

	@Test
	public void getOrderValid(){
		
		
		Order fromOrder=new Order();
		
		Date date=new Date(2020-01-28);
		fromOrder.setORDERID(1);
		fromOrder.setBuyerId(11);
		fromOrder.setAMOUNT(12345.00);
		fromOrder.setDate(date);
		fromOrder.setADDRESS("HYD");
		fromOrder.setSTATUS("ORDER PLACED");

		
		Order order=new Order();
		order=fromOrder;
		Mockito.when(orderRepository.findById(fromOrder.getORDERID())).thenReturn(Optional.of(order));
		
		
		OrderDTO orderDTO=orderMockService.getOrder1(fromOrder.getORDERID());
		OrderDTO test=OrderDTO.valueOf(order);
		

		Assert.assertEquals(order.getAMOUNT(), orderDTO.getAMOUNT());
		
	}

}
