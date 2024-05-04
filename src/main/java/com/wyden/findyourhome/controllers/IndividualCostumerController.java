package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.CreateIndividualCustomerDTO;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.services.IndividualCostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import com.wyden.findyourhome.dto.UpdateCustomerDTO;

import java.util.List;
import java.net.URI;

@RestController
@RequestMapping(value = "/individual-customers")
public class IndividualCostumerController {

    @Autowired
    private IndividualCostumerService service;

    @GetMapping
    public ResponseEntity<List<IndividualCostumer>> findAll() {
        List<IndividualCostumer> customers = service.findAll();
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody CreateIndividualCustomerDTO createIndividualCustomerDTO) {

        IndividualCostumer newCustomer = new IndividualCostumer(
                createIndividualCustomerDTO.getName(),
                createIndividualCustomerDTO.getEmail(),
                createIndividualCustomerDTO.getTelephones(),
                createIndividualCustomerDTO.getAdvertisements(),
                createIndividualCustomerDTO.getCpf()

        );

        IndividualCostumer createdCustomer = service.create(newCustomer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(createdCustomer.getId()).toUri();

        return ResponseEntity.created(uri).body(newCustomer);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateCustomerDTO updateCustomerDTO) {
        IndividualCostumer updatedCustomer = service.update(updateCustomerDTO);
        return ResponseEntity.ok().body(updatedCustomer);
    }

}