package com.infosys.infytel.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.infosys.infytel.user.dto.BuyerDTO;
import com.infosys.infytel.user.dto.BuyerLoginDTO;
import com.infosys.infytel.user.dto.CartDTO;
import com.infosys.infytel.user.dto.CartIdDTO;
import com.infosys.infytel.user.dto.PastOrderDTO;
import com.infosys.infytel.user.dto.ProductDTO;
import com.infosys.infytel.user.dto.SellerDTO;
import com.infosys.infytel.user.dto.SellerLoginDTO;
import com.infosys.infytel.user.service.CartService;
import com.infosys.infytel.user.service.UserService;


//controller
@RestController
@CrossOrigin
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	private Environment environment;
	
	@Value("${order.uri}")
	String orderUri;

	@Value("${product.uri}")
	String productUri;
	
	// Create a new buyer
		@PostMapping(value = "/buyer/register",  consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> createBuyer(@RequestBody BuyerDTO buyerDTO) throws Exception{
			logger.info("Creation request for buyer {}", buyerDTO);
			try {
				Integer buyerId=userService.createBuyer(buyerDTO);
				String successMessage=environment.getProperty("BUYER_SUCCESS")+buyerId;
				return new ResponseEntity<String>(successMessage,HttpStatus.CREATED);
			}
			catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()),e);
			}
		}
		
		// Login buyer
		@PostMapping(value = "/buyer/login",consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Boolean> login(@RequestBody BuyerLoginDTO buyerLoginDTO) {
			try {
				logger.info("Login request for buyer {} with password {}", buyerLoginDTO.getEmail(),buyerLoginDTO.getPassword());
				Boolean check=userService.buyerLogin(buyerLoginDTO);
				return new ResponseEntity<Boolean>(check,HttpStatus.NOT_FOUND);
			}
			catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()),e);
			}
		}
		// finding buyer
				@GetMapping(value = "/buyer/{buyerId}",consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<Boolean> findBuyer(@PathVariable Integer buyerId) {
					try {
						logger.info("find request for buyer {} with buyerId{}",buyerId);
						Boolean check=userService.findBuyerId(buyerId);
						return new ResponseEntity<Boolean>(check,HttpStatus.NOT_FOUND);
					}
					catch(Exception e) {
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()),e);
					}
				}
		
		// Create a new seller
				@PostMapping(value = "/seller/register",  consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<String> createSeller(@RequestBody SellerDTO sellerDTO) throws Exception{
					logger.info("Creation request for seller {}", sellerDTO);
					try {
						Integer sellerId=userService.createSeller(sellerDTO);
						String successMessage=environment.getProperty("Seller_SUCCESS")+sellerId;
						return new ResponseEntity<String>(successMessage,HttpStatus.CREATED);
					}
					catch(Exception e) {
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()),e);
					}
				}
				// Login seller
				@PostMapping(value = "/seller/login",consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<Boolean> sellerlogin(@RequestBody SellerLoginDTO sellerLoginDTO) {
					try {
						logger.info("Login request for seller {} with password {}", sellerLoginDTO.getsEmail(),sellerLoginDTO.getsPassword());
						Boolean check=userService.sellerLogin(sellerLoginDTO);
						return new ResponseEntity<Boolean>(check,HttpStatus.NOT_FOUND);
					}
					catch(Exception e) {
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()),e);
					}
				}
				// finding seller
				@GetMapping(value = "/seller/{sellerId}",produces = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<Boolean> findSeller(@PathVariable Integer sellerId) {
					try {
						logger.info("find request for seller {} with sellerId{}",sellerId);
						Boolean check=userService.findSellerId(sellerId);
						return new ResponseEntity<Boolean>(check,HttpStatus.FOUND);
					}
					catch(Exception e) {
						throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
					}
				}
				//deactivate seller
				@DeleteMapping(value = "/seller/deactivate/{sellerId}")
			    public ResponseEntity<Boolean> deactivateSeller(@PathVariable Integer sellerId) {
					try {
						logger.info("deactivate request for seller {} with sellerId{}",sellerId);
						Boolean check=userService.deactivateSeller(sellerId);
						return new ResponseEntity<Boolean>(check,HttpStatus.FOUND);
					}
					catch(Exception e) {
						throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
					}
			        
			    }
				// activate seller
				@PostMapping(value = "/seller/activate",consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<Boolean> sellerActivate(@RequestBody SellerLoginDTO sellerLoginDTO) {
					try {
						logger.info("Activate request for seller {} with password {}", sellerLoginDTO.getsEmail(),sellerLoginDTO.getsPassword());
						Boolean check=userService.activateSeller(sellerLoginDTO);
						return new ResponseEntity<Boolean>(check,HttpStatus.OK);
					}
					catch(Exception e) {
						throw new ResponseStatusException(HttpStatus.NOT_MODIFIED,environment.getProperty(e.getMessage()),e);
					}
				}
				
				@GetMapping(value = "/cart/buyer/{buyerId}",produces = MediaType.APPLICATION_JSON_VALUE)
				public List<CartDTO> getCartByBuyerId(@PathVariable Integer buyerId) {

						logger.info("find Cart with buyerId{}",buyerId);
						
						List<CartDTO> cartDTOs = cartService.getCartByBuyerId(buyerId);
	
						return cartDTOs;
					}
				
				@PostMapping(value = "/cart/add",consumes = MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<String> addProductToCart(@RequestBody CartDTO cartDTO) {
					try {
						logger.info("Add product to cart{}", cartDTO);

						ProductDTO productDTO=new RestTemplate().getForObject(productUri+cartDTO.getProductId(), ProductDTO.class);
						logger.info("product{}", productDTO);
						String message="";
						if(cartService.checkQuantity(productDTO, cartDTO)){
							cartService.addProductToCart(cartDTO);
							message = environment.getProperty("CART.ADD");
	
						}

				
						return new ResponseEntity<String>(message, HttpStatus.OK);

					}
					catch(Exception e) {
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()),e);
					}
				}
				@DeleteMapping(value = "/cart/remove",consumes = MediaType.APPLICATION_JSON_VALUE)
				public void removeFromCart(@RequestBody CartIdDTO cartIdDTO){
					logger.info("remove product from cart", cartIdDTO);
					cartService.deleteFromCart(cartIdDTO);
					
				}
				@GetMapping(value = "buyer/pastorders",consumes = MediaType.APPLICATION_JSON_VALUE)
				public PastOrderDTO getPastOrders(@RequestBody PastOrderDTO pastOrderDTO) {
					try {
						logger.info("find the previous orders by buyerId {}",pastOrderDTO.getBuyerId());
						PastOrderDTO pastOrder=new RestTemplate().getForObject(orderUri+"pastOrders", PastOrderDTO.class);
						// to be return/...............
						return pastOrder;
						//return new ResponseEntity<ArrayList<PastOrderDTO>>(,HttpStatus.FOUND);
					}
					catch(Exception e) {
						throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
					}
				}
				
				@PostMapping(value = "/seller/updateOrderStatus/{orderId}/{orderStatus}")
				public ResponseEntity<String> updateOrderStatus(@PathVariable("orderId") Integer orderId, @PathVariable("orderStatus") String orderStatus) throws Exception {
					try
					{
						userService.modifyOrderStatus(orderId, orderStatus);
						
						String modificationSuccessMsg = environment.getProperty("SellerOrderAPI.ORDER_STATUS_UPDATE_SUCCESS");
						return new ResponseEntity<String>(modificationSuccessMsg, HttpStatus.OK);
						
					}
					catch (Exception e) {
						
						throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
					}
				}

}
