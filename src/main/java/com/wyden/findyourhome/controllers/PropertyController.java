package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.CreatePropertyDTO;
import com.wyden.findyourhome.dto.UpdateAddressDTO;
import com.wyden.findyourhome.dto.UpdatePropertyDTO;
import com.wyden.findyourhome.entities.Address;
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
        Address address = new Address(
                null,
                propertyDTO.getStreet(),
                propertyDTO.getState(),
                propertyDTO.getZipCode(),
                propertyDTO.getNeighborhood(),
                propertyDTO.getCity()
        );

        Property newProperty = new Property(
                address,
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

        return ResponseEntity.created(uri).body(createdProperty);
    }

    @PutMapping
    public ResponseEntity<Property> update(@RequestBody UpdatePropertyDTO updatePropertyDTO) {
        Property updatedProperty = service.update(updatePropertyDTO);
        return ResponseEntity.ok().body(updatedProperty);

    }

    @PutMapping(value = "/address/{id}")
    public ResponseEntity<Property> updateAddress(@RequestBody UpdateAddressDTO updateAddressDTO, @PathVariable Long id) {
        Property updatedProperty = service.updateAddress(updateAddressDTO, id);
        return ResponseEntity.ok().body(updatedProperty);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Property> findById(@PathVariable Long id) {
        Property property = service.findById(id);

        return ResponseEntity.ok().body(property);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
