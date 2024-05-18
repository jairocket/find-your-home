package com.wyden.findyourhome.services;

import com.wyden.findyourhome.entities.CorporateCostumer;

import com.wyden.findyourhome.exceptions.CostumerException;

import com.wyden.findyourhome.repositories.CorporateCostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CorporateCostumerService {
    @Autowired
    CorporateCostumerRepository repository;

    public CorporateCostumer create(CorporateCostumer corporateCostumer) {
        try{
            return repository.save(corporateCostumer);
        } catch (DataAccessException exception) {
            throw new CostumerException("Email ou CNPJ já cadastrado.");
        }
    }

}
