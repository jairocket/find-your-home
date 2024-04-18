package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.CreatePropertyDTO;
import com.wyden.findyourhome.entities.Property;
import com.wyden.findyourhome.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Property> create(@RequestBody CreatePropertyDTO propertyDTO ) {
        Property newProperty = new Property(
                propertyDTO.getAddress(),
                propertyDTO.getRooms(),
                propertyDTO.getBathrooms(),
                propertyDTO.getPrivateParkingSpace(),
                propertyDTO.getTaxes(),
                propertyDTO.getFee(),
                propertyDTO.getArea(),
                propertyDTO.getType()
        );

        Property createdProperty = service.create(newProperty);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(createdProperty.getId()).toUri();
        return ResponseEntity.created(uri).body(newProperty);
    }
}
