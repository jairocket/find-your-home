package com.wyden.findyourhome.services;

import com.wyden.findyourhome.repositories.CustomerRepository;
import com.wyden.findyourhome.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
