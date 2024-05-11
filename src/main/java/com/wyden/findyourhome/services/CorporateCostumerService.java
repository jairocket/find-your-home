package com.wyden.findyourhome.services;

import com.wyden.findyourhome.entities.CorporateCostumer;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.repositories.CorporateCostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorporateCostumerService {
    @Autowired
    CorporateCostumerRepository repository;

    public CorporateCostumer create(CorporateCostumer newCustomer) {
        return repository.save(newCustomer);
    }

}
