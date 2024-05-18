package com.wyden.findyourhome.services;

import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.exceptions.CostumerException;
import com.wyden.findyourhome.repositories.IndividualCostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class IndividualCostumerService {
    
    @Autowired
    private IndividualCostumerRepository repository;

    public IndividualCostumer create(IndividualCostumer newCostumer) {
        try{
            return repository.save(newCostumer);
        } catch (DataAccessException exception) {
            throw new CostumerException("Email ou CPF já cadastrado");
        }
    }

}
