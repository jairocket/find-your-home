package com.wyden.findyourhome.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyden.findyourhome.entities.Advertisement;
import com.wyden.findyourhome.entities.enums.AdvertisementStatus;
import com.wyden.findyourhome.repositories.AdvertisementRepository;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class AdvertisementService {
    
    @Autowired
    private AdvertisementRepository repository;

    public Advertisement create(Advertisement advertisement) {
        return repository.save(advertisement);
    }
    
    public List<Advertisement> findAll(AdvertisementStatus status){
        List<Advertisement> advertisements = repository.findAll();
        if (status != null) {
            advertisements = advertisements.stream()
                    .filter(ad -> ad.getStatus().equals(status))
                    .collect(Collectors.toList());
        }
        return advertisements;
    }

    public Advertisement findById(Long id) {
        Optional<Advertisement> advertisement = repository.findById(id);
        return advertisement.orElse(null);
    }

    public Advertisement update(Advertisement advertisement) {
        return repository.save(advertisement);
    }

}