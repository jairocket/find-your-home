package com.wyden.findyourhome.services;

import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.wyden.findyourhome.dto.UpdateTelephoneDTO;
import com.wyden.findyourhome.entities.Telephone;
import com.wyden.findyourhome.exceptions.ResourceNotFoundException;
import com.wyden.findyourhome.exceptions.TelephoneException.MultipleMainNumbersException;
import com.wyden.findyourhome.exceptions.TelephoneException.PhoneNumberAlreadyExistsException;
import com.wyden.findyourhome.repositories.TelephoneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TelephoneService {

    @Autowired
    private TelephoneRepository repository;

    public Telephone create(Telephone newTelephone) {
        checkForMainNumbers(newTelephone.getCostumer().getId(), newTelephone);
        try {
            return repository.save(newTelephone);
        } catch (NonUniqueResultException e) {
            throw new PhoneNumberAlreadyExistsException("Erro: Esse número já existe na base de dados.");
        } catch (DataAccessException e) {
            throw new PhoneNumberAlreadyExistsException("Erro: Esse número já existe na base de dados.");
        }
    }

    public List<Telephone> saveAll(List<Telephone> telephones) {

        if (telephones.stream().filter(Telephone::getMainNumber).count() > 1) {
            throw new MultipleMainNumbersException("Erro: Mais de um número principal na requisição.");
        }
        for (Telephone telephone : telephones) {
            checkForMainNumbers(telephone.getCostumer().getId(), telephone);
        }

        try {
            return repository.saveAll(telephones);
        } catch (NonUniqueResultException e) {
            throw new PhoneNumberAlreadyExistsException("Erro: Esse número já existe na base de dados.");
        } catch (DataAccessException e) {
            throw new PhoneNumberAlreadyExistsException("Erro: Esse número já existe na base de dados.");
        }
    }

    public Telephone findById(Long id) {
        Optional<Telephone> telephone = repository.findById(id);
        return telephone.orElse(null);
    }

    public Telephone findMainNumberByCustomerId(Long customerId) {
        return repository.findMainNumberByCustomerId(customerId);
    }

    public Telephone update(UpdateTelephoneDTO newTelephone) {
        Telephone telephone = repository.findById(newTelephone.getId()).orElseThrow(() -> new ResourceNotFoundException(
                "Não foi possível atualizar este recurso. Recurso não encontrado."));
        Telephone existingMainNumber = repository.findMainNumberByCustomerId(telephone.getCostumer().getId());

        if (newTelephone.getId() != existingMainNumber.getId() && newTelephone.getMainNumber() == true){
            throw new MultipleMainNumbersException("Erro: Já existe um número principal vinculado a este cliente.");
        }

        telephone.setMainNumber(newTelephone.getMainNumber());
        telephone.setNumber(newTelephone.getNumber());

        try {
            return repository.save(telephone);
        } catch (NonUniqueResultException e) {
            throw new PhoneNumberAlreadyExistsException("Erro: Esse número já existe na base de dados.");
        } catch (DataAccessException e) {
            throw new PhoneNumberAlreadyExistsException("Erro: Esse número já existe na base de dados.");
        }
    }

    public void delete(Long id) {

        repository.deleteById(id);

    }

    private void checkForMainNumbers(long customerId, Telephone telephone) throws MultipleMainNumbersException {
        if (repository.findMainNumberByCustomerId(customerId) != null && telephone.getMainNumber() == true) {
            throw new MultipleMainNumbersException("Erro: Já existe um número principal vinculado a este cliente.");
        }
    }

}
