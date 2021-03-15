package com.infosys.infytel.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.infytel.user.entity.SellerEntity;


@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer>{
	
	List<SellerEntity> findBysEmail(String sEmail);
}