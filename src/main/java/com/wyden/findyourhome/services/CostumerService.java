package com.wyden.findyourhome.services;

import com.wyden.findyourhome.dto.UpdateCostumerDTO;
import com.wyden.findyourhome.entities.Costumer;
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
        Optional<Costumer> costumer = repository.findById(id);
        return costumer.orElse(null);
    }

    public List<Costumer> findAll() {
        return repository.findAll();
    }

    public Costumer update(UpdateCostumerDTO newCostumer) {
        Costumer costumer = repository.findById(newCostumer.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Não foi possível atualizar este recurso. Recurso não encontrado."));

        costumer.setName(newCostumer.getName());
        costumer.setEmail(newCostumer.getEmail());

        return repository.save(costumer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
