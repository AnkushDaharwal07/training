package com.infosys.infytel.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infytel.user.dto.BuyerDTO;
import com.infosys.infytel.user.dto.BuyerLoginDTO;
import com.infosys.infytel.user.dto.PastOrderDTO;
import com.infosys.infytel.user.dto.SellerDTO;
import com.infosys.infytel.user.dto.SellerLoginDTO;
import com.infosys.infytel.user.entity.BuyerEntity;
import com.infosys.infytel.user.entity.SellerEntity;
import com.infosys.infytel.user.repository.BuyerRepository;
import com.infosys.infytel.user.repository.SellerRepository;
import com.infosys.infytel.user.validator.BuyerValidator;
import com.infosys.infytel.user.validator.SellerValidator;
import com.infosys.infytel.user.dto.OrderStatus;




@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BuyerRepository buyerRepo;
	
	@Autowired
	SellerRepository sellerRepo;
	
//	Register Buyer
	public Integer createBuyer(BuyerDTO buyerDTO) throws Exception {
		BuyerValidator.validateBuyer(buyerDTO);
		buyerDTO.setPhoneNo(buyerDTO.getPhoneNo().substring(4));
		logger.info("Creation request for Buyer {}", buyerDTO);
		BuyerEntity buyer = buyerDTO.createEntity();
		
		return buyerRepo.save(buyer).getBuyerId();
	}
 

//	login Buyer
	public boolean buyerLogin(BuyerLoginDTO buyerLoginDTO) throws Exception {
		BuyerValidator.validateBuyerLogin(buyerLoginDTO);
		logger.info("Login request for buyer {} with password {}", buyerLoginDTO.getEmail(),buyerLoginDTO.getPassword());
		List<BuyerEntity> buyerList = buyerRepo.getByEmail(buyerLoginDTO.getEmail());
		if (!buyerList.isEmpty()) {
			for(BuyerEntity buyerEntity:buyerList) {
			
				if (buyerEntity.getPassword().equals(buyerLoginDTO.getPassword())) {
					return true;
				}
			}
		}

		return false;
	}
	//find buyer by id
	public boolean findBuyerId(Integer buyerId)
	{
		logger.info("find request for buyer {} with buyerId{}", buyerId);
		Optional<BuyerEntity> buyerEntity =buyerRepo.findById(buyerId);
		if (buyerEntity.isPresent())
		{
			return true;
		}
		return false;
	}
	
//	Register seller
	public Integer createSeller(SellerDTO sellerDTO) throws Exception {
		SellerValidator.validateSeller(sellerDTO);
		sellerDTO.setsPhoneNo(sellerDTO.getsPhoneNo().substring(4));
		logger.info("Creation request for seller {}", sellerDTO);
		sellerDTO.setsIsActive(1);
		SellerEntity seller = sellerDTO.createEntity();
		
		return sellerRepo.save(seller).getSellerId();
	}
	
//	login Seller
	public boolean sellerLogin(SellerLoginDTO sellerLoginDTO) throws Exception {
		SellerValidator.validateSellerLogin(sellerLoginDTO);
		logger.info("Login request for seller {} with password {}", sellerLoginDTO.getsEmail(),sellerLoginDTO.getsPassword());
		List<SellerEntity> sellerList = sellerRepo.findBysEmail(sellerLoginDTO.getsEmail());
		if (!sellerList.isEmpty()) {
			for(SellerEntity sellerEntity:sellerList) {
				if(sellerEntity.getIsActive()==0) {
					throw new Exception("Seller.DEACTIVATED");
				}
				if (sellerEntity.getsPassword().equals(sellerLoginDTO.getsPassword())) {
					return true;
				}
			}
		}

		return false;
	}
	//find seller by id
		public boolean findSellerId(Integer sellerId)
		{
			logger.info("find request for seller {} with sellerId{}", sellerId);
			Optional<SellerEntity> sellerEntity =sellerRepo.findById(sellerId);
			if (sellerEntity.isPresent())
			{
				return true;
			}
			return false;
		}
		
	// deactivate seller
		public boolean deactivateSeller(Integer sellerId) {
			logger.info("deactivate request for seller {} with sellerId{}", sellerId);
			Optional<SellerEntity> sellerEntity =sellerRepo.findById(sellerId);
			if (sellerEntity.isPresent())
			{
				SellerEntity seller=sellerEntity.get();
				seller.setIsActive(0);
				sellerRepo.save(seller);
				return true;
				
			}
			return false;
			
		}
	// activate seller
		public boolean activateSeller(SellerLoginDTO sellerLoginDTO) {
			logger.info("activate request for seller {} with email{}", sellerLoginDTO.getsEmail());
			List<SellerEntity> sellerEntities =sellerRepo.findBysEmail(sellerLoginDTO.getsEmail());
			if(!sellerEntities.isEmpty()) {
				for(SellerEntity sellerEntity:sellerEntities) {
					if (sellerEntity.getsPassword().equals(sellerLoginDTO.getsPassword())) {
						sellerEntity.setIsActive(1);
						sellerRepo.save(sellerEntity);
						
					}
				}
				return true;
			}
			return false;
		}


		public ArrayList<PastOrderDTO> getpastOrders(PastOrderDTO pastOrderDTO) {
			return null;
		
		}
		
		public void modifyOrderStatus(Integer orderId, String orderStatus) throws Exception{
			//get from order 
		}


		
 	
}