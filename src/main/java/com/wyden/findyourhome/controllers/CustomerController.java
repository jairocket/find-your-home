package com.wyden.findyourhome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import com.wyden.findyourhome.services.CustomerService;
import com.wyden.findyourhome.dto.CreateCustomerDTO;
import com.wyden.findyourhome.dto.UpdateCustomerDTO;
import com.wyden.findyourhome.entities.Customer;
import java.util.List;
import com.wyden.findyourhome.utils.*;
import java.net.URI;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = service.findAll();
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        if (createCustomerDTO.getCpf() == null && createCustomerDTO.getCnpj() == null
                || (createCustomerDTO.getCpf() != null && createCustomerDTO.getCnpj() != null)) {
            return ResponseEntity.badRequest().body("Must provide either CPF or CNPJ, and only one of them");
        }
        if (createCustomerDTO.getCpf() != null) {
            if (!validations.isValidCpf(createCustomerDTO.getCpf())) {
                return ResponseEntity.badRequest().body("Invalid CPF");
            }
        } else {
            if (!validations.isValidCnpj(createCustomerDTO.getCnpj())) {
                return ResponseEntity.badRequest().body("Invalid CNPJ");
            }

        }

        Customer newCustomer = new Customer(
                createCustomerDTO.getName(),
                createCustomerDTO.getEmail(),
                createCustomerDTO.getCpf(),
                createCustomerDTO.getCnpj(),
                null,
                null);

        Customer createdCustomer = service.create(newCustomer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(createdCustomer.getId()).toUri();

        return ResponseEntity.created(uri).body(newCustomer);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateCustomerDTO updateCustomerDTO) {
        if (updateCustomerDTO.getCpf() == null && updateCustomerDTO.getCnpj() == null
                || (updateCustomerDTO.getCpf() != null && updateCustomerDTO.getCnpj() != null)) {
            return ResponseEntity.badRequest().body("Must provide either CPF or CNPJ, and only one of them");
        }
        Customer updatedCustomer = service.update(updateCustomerDTO);
        return ResponseEntity.ok().body(updatedCustomer);
    }

}
