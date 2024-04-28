package com.wyden.findyourhome.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wyden.findyourhome.services.CustomerService;
import com.wyden.findyourhome.entities.Customer;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = service.findAll();
        return ResponseEntity.ok().body(customers);
    }
    
}
