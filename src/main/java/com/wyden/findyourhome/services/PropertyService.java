package com.wyden.findyourhome.services;

import com.wyden.findyourhome.repositories.PropertyRepository;
import com.wyden.findyourhome.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository repository;

    public List<Property> findAll() {
        return repository.findAll();
    }

    public Property create(Property newProperty) {
        return repository.save(newProperty);
    }
}
