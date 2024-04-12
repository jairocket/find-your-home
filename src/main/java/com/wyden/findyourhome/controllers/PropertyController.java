package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.entities.Property;
import com.wyden.findyourhome.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @GetMapping
    public ResponseEntity<List<Property>> findAll() {
        List<Property> properties = service.findAll();
        return ResponseEntity.ok().body(properties);
    }
}
