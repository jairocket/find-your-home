package com.wyden.findyourhome.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyden.findyourhome.entities.Telephone;
import com.wyden.findyourhome.repositories.TelephoneRepository;

@Service
public class TelephoneService {

    @Autowired
    private TelephoneRepository repository;

    public Telephone create(Telephone newTelephone) {
        return repository.save(newTelephone);
    }

}
