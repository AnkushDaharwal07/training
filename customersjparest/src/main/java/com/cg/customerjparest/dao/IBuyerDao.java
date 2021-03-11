package com.cg.customerjparest.dao;

import com.cg.customerjparest.entities.Buyer;


public interface IBuyerDao {
	
	Buyer add(Buyer buyer);
	
	Buyer update(Buyer buyer);

	Buyer findById(int buyerId);
	boolean findByPhoneNumber(String string);
	Buyer findByEmail(String email);
	
	Buyer delete(int buyerId);
	
	java.util.List<Buyer> findAll();
}
