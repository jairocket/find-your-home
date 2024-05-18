package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.CreateAdvertisementDTO;
import com.wyden.findyourhome.dto.UpdateAdversementDTO;
import com.wyden.findyourhome.entities.Costumer;
import com.wyden.findyourhome.entities.Property;
import com.wyden.findyourhome.entities.enums.AdvertisementStatus;
import com.wyden.findyourhome.services.CostumerService;
import com.wyden.findyourhome.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.wyden.findyourhome.entities.Advertisement;
import com.wyden.findyourhome.services.AdvertisementService;
import java.util.List;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;

@RestController
@RequestMapping(value = "/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService service;

    @Autowired
    private CostumerService costumerService;

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Advertisement> create(@RequestBody CreateAdvertisementDTO createAdvertisementDTO) {

        Costumer costumer = costumerService.findById(createAdvertisementDTO.getCostumerId());
        Property property = propertyService.findById(createAdvertisementDTO.getPropertyId());

        Advertisement advertisement = new Advertisement(
                costumer,
                AdvertisementStatus.ACTIVE,
                property,
                Instant.now(),
                createAdvertisementDTO.getValue(),
                null,
                createAdvertisementDTO.getDescription()
        );

        Advertisement createdAdvertisement = service.create(advertisement);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(createdAdvertisement.getId()).toUri();

        return ResponseEntity.created(uri).body(createdAdvertisement);

    }

    @PutMapping
    public ResponseEntity<Advertisement> update(@RequestBody UpdateAdversementDTO updateAdversementDTO) {
        Advertisement advertisement = service.findById(updateAdversementDTO.getId());

        advertisement.setDescription(updateAdversementDTO.getDescription());
        advertisement.setValue(updateAdversementDTO.getValue());

        Advertisement updatedAdvertisement = service.update(advertisement);

        return ResponseEntity.ok().body(updatedAdvertisement);
    }
   
    @PutMapping(value = "/{id}")
    public ResponseEntity<Advertisement> updateSoldStatus(@PathVariable Long id) {
        Advertisement advertisement = service.findById(id);

        advertisement.setStatus(AdvertisementStatus.SOLD);
        advertisement.setSoldIn(Instant.now());
        Advertisement updatedAdvertisement = service.update(advertisement);

        return ResponseEntity.ok().body(updatedAdvertisement);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Advertisement> findById(@PathVariable Long id){
        Advertisement advertisement = service.findById(id);
        
        return ResponseEntity.ok().body(advertisement);
    }

    @GetMapping
    public ResponseEntity<List<Advertisement>> findAll() {
       java.util.List<Advertisement> advertisement = service.findAll();
        return ResponseEntity.ok().body(advertisement);
    }
}