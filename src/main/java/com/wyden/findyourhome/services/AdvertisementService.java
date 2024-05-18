package com.wyden.findyourhome.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyden.findyourhome.entities.Advertisement;

import com.wyden.findyourhome.repositories.AdvertisementRepository;

import java.util.Optional;
import java.util.List;

@Service
public class AdvertisementService {
    
    @Autowired
    private AdvertisementRepository repository;
    
    public List<Advertisement> findAll(){
        return repository.findAll();
   
    }
      public Advertisement findById(Long id) {
        Optional<Advertisement> advertisement = repository.findById(id);
        return advertisement.orElse(null);
    }

}