package com.cg.customerjparest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customerjparest.dao.IBuyerDao;

import com.cg.customerjparest.entities.Buyer;

import com.cg.customerjparest.util.ValidationUtil;

import java.util.List;

import javax.persistence.EntityManager;

@Transactional
@Service
public class BuyerServiceImpl implements IBuyerService {
    //private static final Logger Log= LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private IBuyerDao dao;


    @Override
    public Buyer register(Buyer buyer) {
        boolean validate = ValidationUtil.validateBuyer(buyer);
        boolean exist = dao.findByPhoneNumber(buyer.getPhoneNumber());
        if(exist==true) {
        	
        	/// work to do
        	System.out.println("User exist");
        }
        buyer = dao.add(buyer);
        return buyer;
    }



	
	  @Override
	    public List<Buyer> findAll() {
	        List<Buyer> list = dao.findAll();
	        return list;
	    }




	@Override

	public Buyer login(String email) {
		boolean validate = ValidationUtil.validateBuyer(email);
		Buyer buyer = dao.findByEmail(email);
        return buyer;
		
	}




	@Override
	public Buyer removeAccount(int buyerId) {
		Buyer buyer = dao.delete(buyerId);
        return buyer;
	}




	@Override
	public Buyer login(int buyerId) {
		// TODO Auto-generated method stub
		return null;
	}






}
