package com.infosys.infytel.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.infosys.infytel.user.dto.CartDTO;
import com.infosys.infytel.user.dto.CartIdDTO;
import com.infosys.infytel.user.dto.ProductDTO;

import com.infosys.infytel.user.entity.CartEntity;
import com.infosys.infytel.user.entity.CartId;

import com.infosys.infytel.user.repository.CartRepository;


@Service
public class CartService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CartRepository cartRepository;
	
	public List<CartDTO> getCartByBuyerId(int buyerId){
		List<CartDTO> cartDTOs=new ArrayList<CartDTO>();;
		
		logger.info("GET cart for buyer {}", buyerId);
		
		List<CartEntity> carts=cartRepository.findBybuyerId(buyerId);
		
		//if(!carts.isEmpty()){
			for(CartEntity cart:carts){
				cartDTOs.add(CartDTO.valueOf(cart));
			}			
//		}
		
		return cartDTOs;
		
	}
	
	public void addProductToCart(CartDTO cartDTO) throws Exception {

		logger.info("Creation cart for buyer {}", cartDTO);
		
		CartId cartId =new CartId();
		cartId.setBuyerId(cartDTO.getBuyerId());
		cartId.setProductId(cartDTO.getProductId());
		
		Optional<CartEntity> optCart=cartRepository.findById(cartId);
		System.out.print(optCart.isPresent());
		
		if(optCart.isPresent()){
			throw new Exception("CartService.PRESENT");
		}

		CartEntity cart = cartDTO.createEntity();
		cartRepository.save(cart);
	}
	
	public void deleteFromCart(CartIdDTO cartIdDTO){
		
		CartId cartId=cartIdDTO.createEntity();
		
		cartRepository.deleteById(cartId);
		
	}
	
	public Boolean checkQuantity(ProductDTO productDTO ,CartDTO cartDTO ) throws Exception{
		System.out.println(cartDTO);
		if(cartDTO.getQuantity()<=productDTO.getStock())
			return true;
		
		throw new Exception("PRODUCT.STOCK");
		
	}


	

}
