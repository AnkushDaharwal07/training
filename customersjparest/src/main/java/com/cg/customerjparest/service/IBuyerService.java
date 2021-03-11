package com.cg.customerjparest.service;

import java.util.List;

import com.cg.customerjparest.entities.Buyer;

public interface IBuyerService {

	Buyer register(Buyer buyer);
	Buyer login(int buyerId);
	Buyer removeAccount(int buyerId);

	List<Buyer>findAll();
	Buyer login(String email);

	
}
