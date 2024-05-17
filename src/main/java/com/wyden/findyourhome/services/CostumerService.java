package com.wyden.findyourhome.services;

import com.wyden.findyourhome.dto.UpdateCustomerDTO;
import com.wyden.findyourhome.entities.Costumer;
import com.wyden.findyourhome.exceptions.CustomerException;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import com.wyden.findyourhome.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository repository;

    public Costumer findById(Long id) {
        Optional<Costumer> customer = repository.findById(id);
        return customer.orElse(null);
    }

    public List<Costumer> findAll() {
        return repository.findAll();
    }

    public Costumer update(UpdateCustomerDTO newCustomer) {
        Costumer customer = repository.findById(newCustomer.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Não foi possível atualizar este recurso. Recurso não encontrado."));

        customer.setName(newCustomer.getName());
        customer.setEmail(newCustomer.getEmail());

        return repository.save(customer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
