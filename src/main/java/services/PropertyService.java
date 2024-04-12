package services;

import entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PropertyRepository;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository repository;

    public List<Property> findAll() {
        return repository.findAll();
    }
}
