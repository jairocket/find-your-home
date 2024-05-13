package com.wyden.findyourhome.services;

import com.wyden.findyourhome.entities.CorporateCostumer;
import com.wyden.findyourhome.exceptions.CustomerException;
import com.wyden.findyourhome.repositories.CorporateCostumerRepository;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CorporateCostumerService {
    @Autowired
    CorporateCostumerRepository repository;

    public CorporateCostumer create(CorporateCostumer newCustomer) {
        try{
            return repository.save(newCustomer);
        } catch (DataAccessException exception) {
            throw new CustomerException("Este cnpj já foi cadastrado.");
        }
    }

}
