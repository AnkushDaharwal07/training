package com.cg.customerjparest.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerjparest.dto.UserDetails;
import com.cg.customerjparest.entities.Buyer;
import com.cg.customerjparest.service.IBuyerService;



/*
 * http://localhost:8989/customers
 */


@RequestMapping("/")
@RestController
public class BuyController {

    @Autowired
    private IBuyerService service;;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public Buyer add(@RequestBody UserDetails requestData) {
        Buyer buyer = new Buyer();
        buyer = service.register(buyer);
        
        return buyer;
    }
    
    @PostMapping("/login")
    public Buyer login(@RequestBody UserDetails requestData) {
        Buyer buyer = new Buyer();
        buyer = service.login(buyer.getEmail());
        
        return buyer;
    }
   
    @DeleteMapping("/delete")
    public Buyer removeAccount(@RequestBody UserDetails requestData) {
        Buyer buyer = new Buyer();
        buyer = service.removeAccount(buyer.getBuyerId());
        
        return buyer;
    }



}
