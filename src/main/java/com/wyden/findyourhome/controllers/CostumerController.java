package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.CreateIndividualCustomerDTO;
import com.wyden.findyourhome.dto.CreateTelephoneDTO;
import com.wyden.findyourhome.entities.Costumer;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.entities.Telephone;
import com.wyden.findyourhome.exceptions.*;
import com.wyden.findyourhome.exceptions.TelephoneException.*;
import com.wyden.findyourhome.services.CostumerService;
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
@RequestMapping(value = "/customers")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @Autowired
    private IndividualCostumerService individualCostumerService;

    @Autowired
    private TelephoneService telephoneService;

    @GetMapping
    public ResponseEntity<List<Costumer>> findAll() {
        List<Costumer> customers = costumerService.findAll();
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping("/individual")
    public ResponseEntity<IndividualCostumer> createCustomer(
            @RequestBody CreateIndividualCustomerDTO createIndividualCustomerDTO) {

        var telephones = createIndividualCustomerDTO
                .getTelephones()
                .stream()
                .map((dto) -> new Telephone(null, dto.getNumber(), dto.getMainNumber()))
                .toList();

        if (telephones.stream().anyMatch(t -> t.hasDuplicateNumber(telephones))) {
            throw new DuplicatePhoneNumberException("Erro: Números duplicados encontrados.");
        }

        if (telephones.stream().filter(Telephone::getMainNumber).count() > 1) {
            throw new MultipleMainNumbersException("Erro: Mais de um número principal encontrado.");
        }

        IndividualCostumer newCustomer = new IndividualCostumer(
                createIndividualCustomerDTO.getName(),
                createIndividualCustomerDTO.getEmail(),
                null,
                createIndividualCustomerDTO.getAdvertisements(),
                createIndividualCustomerDTO.getCpf()

        );

        IndividualCostumer createdCustomer = individualCostumerService.create(newCustomer);

        telephones.forEach(phone -> phone.setCustomer(createdCustomer));

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

        if (telephoneService.findTelephoneByNumberAndCustomerId(telephone.getNumber(), telephone.getCustomerId()) != null) {
            throw new PhoneNumberAlreadyExistsException("Erro: Número de telefone já existe para este cliente.");
        }
        if (telephoneService.findMainNumberByCustomerId(customer.getId()) != null && telephone.getMainNumber() == true) {
            throw new MultipleMainNumbersException("Erro: Já existe um número principal vinculado a este cliente.");
        }

        Telephone newTelephone = new Telephone(
                customer,
                telephone.getNumber(),
                telephone.getMainNumber());

        Telephone createdTelephone = telephoneService.create(newTelephone);
        return ResponseEntity.ok().body(createdTelephone);

    }

    @PutMapping(value = "telephone")
    public ResponseEntity<Telephone> updateTelephone(@RequestBody UpdateTelephoneDTO updateTelephone) {

        Telephone telephone = telephoneService.findById(updateTelephone.getId());

        if (telephoneService.findMainNumberByCustomerId(telephone.getCustomer().getId()) != null
                && updateTelephone.getId() != telephone.getId()) {
            throw new MultipleMainNumbersException("Erro: Já existe um número principal vinculado a este cliente.");
        }

        Telephone updatedTelephone = telephoneService.update(updateTelephone);
        return ResponseEntity.ok().body(updatedTelephone);

    }

    @DeleteMapping(value = "/telephone/{id}")
    public ResponseEntity<Void> deleteTelephone(@PathVariable Long id) {
        telephoneService.delete(id);
        return ResponseEntity.noContent().build();
    }

}