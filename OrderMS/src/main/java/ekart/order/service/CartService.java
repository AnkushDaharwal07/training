package ekart.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ekart.order.dto.ProductsOrderedDTO;
import ekart.order.entity.MyKey;
import ekart.order.repository.ProductsOrderedRepository;

@Service
public class CartService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductsOrderedRepository productsOrderedRepository;

	public void addItemToCart(MyKey muKey,ProductsOrderedDTO productsOrderedDTO) {

    }
}
