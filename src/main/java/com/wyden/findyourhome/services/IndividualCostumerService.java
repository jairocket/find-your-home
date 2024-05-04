package com.wyden.findyourhome.services;

import com.wyden.findyourhome.dto.UpdateCustomerDTO;
import com.wyden.findyourhome.entities.IndividualCostumer;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import com.wyden.findyourhome.repositories.IndividualCostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class IndividualCostumerService {
    
    @Autowired
    private IndividualCostumerRepository repository;

    public List<IndividualCostumer> findAll() {
        return repository.findAll();
    }

    public IndividualCostumer create(IndividualCostumer newCustomer) {
        return repository.save(newCustomer);
    }

    public IndividualCostumer update(UpdateCustomerDTO newCustomer) {
        IndividualCostumer customer = repository.findById(newCustomer.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                "Não foi possível atualizar este recurso. Recurso não encontrado."));

        customer.setName(newCustomer.getName());
        customer.setEmail(newCustomer.getEmail());

        return repository.save(customer);
    }

    public IndividualCostumer findById(Long id) {
        Optional<IndividualCostumer> customer = repository.findById(id);
        return customer.orElse(null);
    }

    public void delete(Long id) {

        repository.deleteById(id);

    }

}
