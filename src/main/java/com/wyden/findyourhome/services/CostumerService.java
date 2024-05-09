package com.wyden.findyourhome.services;

import com.wyden.findyourhome.entities.Costumer;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    CostumerRepository repository;

    public Costumer findById(Long id) {
        Optional<Costumer> customer = repository.findById(id);
        return customer.orElse(null);
    }
}
