package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.*;
import com.wyden.findyourhome.entities.CorporateCostumer;
import com.wyden.findyourhome.entities.Costumer;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.entities.Telephone;
import com.wyden.findyourhome.exceptions.*;
import com.wyden.findyourhome.services.CorporateCostumerService;
import com.wyden.findyourhome.services.CostumerService;
import com.wyden.findyourhome.services.IndividualCostumerService;
import com.wyden.findyourhome.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import com.wyden.findyourhome.dto.UpdateCostumerDTO;
import com.wyden.findyourhome.dto.UpdateTelephoneDTO;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.net.URI;

@RestController
@RequestMapping(value = "/costumers")
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
        List<Costumer> costumers = costumerService.findAll();
        return ResponseEntity.ok().body(costumers);
    }

    @PostMapping("/individual")
    @Transactional
    public ResponseEntity<IndividualCostumer> createCostumer(
            @RequestBody CreateIndividualCostumerDTO createIndividualCostumerDTO
    ) {

        IndividualCostumer individualCostumer = new IndividualCostumer(
                createIndividualCostumerDTO.getName(),
                createIndividualCostumerDTO.getEmail(),
                null,
                createIndividualCostumerDTO.getAdvertisements(),
                createIndividualCostumerDTO.getCpf()
        );

        IndividualCostumer createdCostumer = individualCostumerService.create(individualCostumer);

        var telephones = createIndividualCostumerDTO
                .getTelephones()
                .stream()
                .map((dto) -> new Telephone(createdCostumer, dto.getNumber(), dto.getMainNumber()))
                .toList();
        var phones = telephoneService.saveAll(telephones);

        individualCostumer.setTelephones(phones);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(createdCostumer.getId()).toUri();

        return ResponseEntity.created(uri).body(individualCostumer);
    }

    @PostMapping("/corporate")
    public ResponseEntity<CorporateCostumer> createCorporateCostumer(
            @RequestBody CreateCorporateCostumerDTO createCorporateCostumerDTO
    ) {
        CorporateCostumer newCostumer = new CorporateCostumer(
                createCorporateCostumerDTO.getName(),
                createCorporateCostumerDTO.getEmail(),
                null,
                createCorporateCostumerDTO.getAdvertisements(),
                createCorporateCostumerDTO.getCnpj()
        );

        CorporateCostumer corporateCostumer = corporateCostumerService.create(newCostumer);

        var telephones = createCorporateCostumerDTO
                .getTelephones()
                .stream()
                .map((dto)-> new Telephone(corporateCostumer, dto.getNumber(), dto.getMainNumber()))
                .toList();

        var phones = telephoneService.saveAll(telephones);

        newCostumer.setTelephones(phones);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(corporateCostumer.getId()).toUri();

        return ResponseEntity.created(uri).body(newCostumer);
    }

    @PutMapping
    public ResponseEntity<Costumer> update(@RequestBody UpdateCostumerDTO updateCostumerDTO) {
        Costumer updatedCostumer = costumerService.update(updateCostumerDTO);
        return ResponseEntity.ok().body(updatedCostumer);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Costumer> findById(@PathVariable Long id) {
        Costumer costumer = costumerService.findById(id);
        return ResponseEntity.ok().body(costumer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        costumerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/telephone")
    public ResponseEntity<Telephone> createTelephone(@RequestBody CreateTelephoneDTO telephone) {
        Costumer costumer = costumerService.findById(telephone.getCostumerId());
        if (costumer == null) {
            throw new ResourceNotFoundException(
                    "Não foi possível localizar o cliente.");
        }
        
        Telephone newTelephone = new Telephone(
                costumer,
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