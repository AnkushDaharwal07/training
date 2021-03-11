package com.cg.customerjparest.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cg.customerjparest.entities.Buyer;
import com.cg.customerjparest.exception.CustomerNotFoundException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class BuyerDaoImpl implements IBuyerDao {
   //private static final Logger Log= LoggerFactory.getLogger(CustomerDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Buyer  add(Buyer buyer) {
        entityManager.persist(buyer);
		return buyer;
	}


   @Override
    public Buyer update(Buyer buyer) {
        boolean success=checkExists(buyer.getBuyerId());
        /*if(!success){
            throw new BuyerNotFoundException("Can't update, customer doesn't exist for id="+buyer.getId());
        }*/
        buyer = entityManager.merge(buyer);
        return buyer;
    }

    public boolean checkExists(long id){
    	Buyer buyer = entityManager.find(Buyer.class, id);
        boolean result= buyer!=null;
        return result;
    }
    
  

	@Override
	public Buyer delete(int buyerId) {
        Buyer buyer = entityManager.find(Buyer.class, buyerId);
       /* if (buyer == null) {
            throw new BuyerNotFoundException("Buyer not found for id=" + id);
        }*/
        return buyer;
	}
	@Override
	public List<Buyer> findAll() {
		  String ql="from Buyer";
	        TypedQuery<Buyer>query=entityManager.createQuery(ql,Buyer.class);
	        List<Buyer>list=query.getResultList();
	        return list;
	}


	@Override
	public Buyer findById(int buyerId) {

        Buyer buyer = entityManager.find(Buyer.class, buyerId);
        /*if (buyer == null) {
            throw new CustomerNotFoundException("customer not found for id=" + id);
        }*/
        return buyer;
	}


	@Override
	public boolean findByPhoneNumber(String phoneNumber) {
		Buyer buyer = entityManager.find(Buyer.class, phoneNumber);
		boolean result= buyer!=null;
        return result;
	}


	@Override
	public Buyer findByEmail(String email) {
		Buyer buyer = entityManager.find(Buyer.class, email);

        return buyer;
	}



}
