package com.infosys.infytel.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.infytel.user.entity.WishlistEntity;



@Repository
public interface WishlistRepository extends JpaRepository<WishlistEntity, Integer>{

}