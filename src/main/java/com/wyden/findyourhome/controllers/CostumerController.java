package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.*;
import com.wyden.findyourhome.entities.CorporateCostumer;
import com.wyden.findyourhome.entities.Costumer;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.entities.Telephone;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import com.wyden.findyourhome.services.CorporateCostumerService;
import com.wyden.findyourhome.services.CostumerService;
import com.wyden.findyourhome.services.IndividualCostumerService;
import com.wyden.findyourhome.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.net.URI;

@RestController
@RequestMapping(value = "/customers")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @Autowired
    private IndividualCostumerService individualCostumerService;

    @Autowired
    private CorporateCostumerService corporateCostumerService;

    @Autowired
    private TelephoneService telephoneService;

    @GetMapping
    public ResponseEntity<List<Costumer>> findAll() {
        List<Costumer> customers = costumerService.findAll();
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping("/individual")
    public ResponseEntity<IndividualCostumer> createIndividualCustomer(@RequestBody CreateIndividualCustomerDTO createIndividualCustomerDTO) {

        IndividualCostumer newCustomer = new IndividualCostumer(
                createIndividualCustomerDTO.getName(),
                createIndividualCustomerDTO.getEmail(),
                null,
                createIndividualCustomerDTO.getAdvertisements(),
                createIndividualCustomerDTO.getCpf()

        );

        IndividualCostumer createdCustomer = individualCostumerService.create(newCustomer);

        var telephones = createIndividualCustomerDTO
                .getTelephones()
                .stream()
                .map((dto)-> new Telephone(createdCustomer, dto.getNumber(), dto.getMainNumber()))
                .toList();

        var phones = telephoneService.saveAll(telephones);

        newCustomer.setTelephones(phones);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(createdCustomer.getId()).toUri();

        return ResponseEntity.created(uri).body(newCustomer);
    }

    @PostMapping("/corporate")
    public ResponseEntity<CorporateCostumer> createCorporateCustomer(@RequestBody CreateCorporateCustomerDTO createCorporateCustomerDTO) {

        CorporateCostumer newCustomer = new CorporateCostumer(
                createCorporateCustomerDTO.getName(),
                createCorporateCustomerDTO.getEmail(),
                null,
                createCorporateCustomerDTO.getAdvertisements(),
                createCorporateCustomerDTO.getCnpj()

        );

        CorporateCostumer createdCustomer = corporateCostumerService.create(newCustomer);

        var telephones = createCorporateCustomerDTO
                .getTelephones()
                .stream()
                .map((dto)-> new Telephone(createdCustomer, dto.getNumber(), dto.getMainNumber()))
                .toList();

        var phones = telephoneService.saveAll(telephones);

        newCustomer.setTelephones(phones);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(createdCustomer.getId()).toUri();

        return ResponseEntity.created(uri).body(newCustomer);
    }

    @PutMapping
    public ResponseEntity<Costumer> update(@RequestBody UpdateCustomerDTO updateCustomerDTO) {
        Costumer updatedCustomer = costumerService.update(updateCustomerDTO);
        return ResponseEntity.ok().body(updatedCustomer);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Costumer> findById(@PathVariable Long id) {
        Costumer customer = costumerService.findById(id);
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        costumerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/telephone")
    public ResponseEntity<Telephone> createTelephone(@RequestBody CreateTelephoneDTO telephone) {
        Costumer customer = costumerService.findById(telephone.getCustomerId());
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