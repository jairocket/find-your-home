package com.wyden.findyourhome.services;

import com.wyden.findyourhome.dto.UpdateCustomerDTO;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import com.wyden.findyourhome.repositories.IndividualCostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class IndividualCostumerService {
    
    @Autowired
    private IndividualCostumerRepository repository;

    public IndividualCostumer create(IndividualCostumer newCustomer) {
        return repository.save(newCustomer);
    }

}
