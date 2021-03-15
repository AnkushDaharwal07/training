package com.infosys.infytel.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infytel.user.entity.CartEntity;
import com.infosys.infytel.user.entity.CartId;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, CartId> {

	List<CartEntity> findBybuyerId(int buyerId);

}
