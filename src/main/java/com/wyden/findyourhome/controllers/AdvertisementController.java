package com.wyden.findyourhome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyden.findyourhome.entities.Advertisement;
import com.wyden.findyourhome.services.AdvertisementService;

@RestController
@RequestMapping(value = "/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Advertisement> findById(@PathVariable Long id){
        Advertisement advertisement = service.findById(id);
        
        return ResponseEntity.ok().body(advertisement);
    }

}