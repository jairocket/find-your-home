package com.wyden.findyourhome.services;

import com.wyden.findyourhome.repositories.CustomerRepository;
import com.wyden.findyourhome.entities.Customer;
import com.wyden.findyourhome.dto.UpdateCustomerDTO;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer create(Customer newCustomer) {
        return repository.save(newCustomer);
    }

    public Customer update(UpdateCustomerDTO newCustomer) {
        Customer customer = repository.findById(newCustomer.getId()).orElseThrow(() -> new ResourceNotFoundException(
                "Não foi possível atualizar este recurso. Recurso não encontrado."));

        customer.setName(newCustomer.getName());
        customer.setEmail(newCustomer.getEmail());
        customer.setCpf(newCustomer.getCpf());
        customer.setCnpj(newCustomer.getCnpj());

        return repository.save(customer);
    }
}
