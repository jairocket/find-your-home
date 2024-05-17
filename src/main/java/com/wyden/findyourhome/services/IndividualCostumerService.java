package com.wyden.findyourhome.services;

import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.exceptions.CustomerException;
import com.wyden.findyourhome.repositories.IndividualCostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class IndividualCostumerService {
    
    @Autowired
    private IndividualCostumerRepository repository;

    public IndividualCostumer create(IndividualCostumer newCustomer) {
        try{
            return repository.save(newCustomer);
        } catch (DataAccessException exception) {
            throw new CustomerException("Email ou CPF já cadastrado");
        }
    }

}
