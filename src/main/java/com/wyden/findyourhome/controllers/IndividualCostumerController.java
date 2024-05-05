package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.CreateIndividualCustomerDTO;
import com.wyden.findyourhome.dto.CreateTelephoneDTO;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.entities.Telephone;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import com.wyden.findyourhome.services.IndividualCostumerService;
import com.wyden.findyourhome.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import com.wyden.findyourhome.dto.UpdateCustomerDTO;
import com.wyden.findyourhome.dto.UpdateTelephoneDTO;


import java.util.List;
import java.net.URI;

@RestController
@RequestMapping(value = "/individual-customers")
public class IndividualCostumerController {

    @Autowired
    private IndividualCostumerService service;

    @Autowired
    private TelephoneService telephoneService;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        IndividualCostumer customer = service.findById(id);
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/telephone")
    public ResponseEntity<Telephone> createTelephone(@RequestBody CreateTelephoneDTO telephone) {
        IndividualCostumer customer = service.findById(telephone.getCustomerId());
        if (customer == null) {
            throw new ResourceNotFoundException(
                "Não foi possível localizar o cliente.");
        }

        Telephone newTelephone = new Telephone(
                customer,
                telephone.getNumber(),
                telephone.getMainNumber());

        Telephone createdTelephone = telephoneService.create(newTelephone);
        return ResponseEntity.ok().body(createdTelephone);

    }

    @PutMapping(value = "/telephone")
    public ResponseEntity<Telephone> updateTelephone(@RequestBody UpdateTelephoneDTO updateTelephone) {
        Telephone updatedTelephone = telephoneService.update(updateTelephone);
        return ResponseEntity.ok().body(updatedTelephone);

    }

    @DeleteMapping(value = "/telephone/{id}")
    public ResponseEntity<Void> deleteTelephone(@PathVariable Long id) {
        telephoneService.delete(id);
        return ResponseEntity.noContent().build();
    }


}