package com.wyden.findyourhome.services;

import com.wyden.findyourhome.dto.UpdateAddressDTO;
import com.wyden.findyourhome.dto.UpdatePropertyDTO;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import com.wyden.findyourhome.repositories.PropertyRepository;
import com.wyden.findyourhome.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Property findById(Long id) {
        Optional<Property> property = repository.findById(id);
        return property.orElse(null);
    }

    public Property update(UpdatePropertyDTO newProperty) {
        Property property = repository.findById(newProperty.getId()).orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar este recurso. Recurso não encontrado."));

        property.setArea(newProperty.getArea());
        property.setRooms(newProperty.getRooms());
        property.setBathrooms(newProperty.getBathrooms());
        property.setFee(newProperty.getFee());
        property.setPrivateParkingSpace(newProperty.getPrivateParkingSpace());
        property.setTaxes(newProperty.getTaxes());

        return repository.save(property);
    }

    public Property updateAddress(UpdateAddressDTO updateAddressDTO, Long id) {
        Property property = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar este recurso. Recurso não encontrado."));

        property.getAddress().setStreet(updateAddressDTO.getStreet());
        property.getAddress().setNeighborhood(updateAddressDTO.getNeighborhood());
        property.getAddress().setCity(updateAddressDTO.getCity());
        property.getAddress().setZipCode(updateAddressDTO.getZipCode());
        property.getAddress().setState(updateAddressDTO.getState());

        return repository.save(property);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
