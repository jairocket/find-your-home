package com.wyden.findyourhome.entities;

import com.wyden.findyourhome.exceptions.CustomerException;
import jakarta.persistence.Entity;

import java.util.List;
import java.util.Optional;

@Entity(name = "INDIVIDUAL_CUSTOMER")
public class IndividualCostumer extends AbstractCostumer {
    private String CPF;

    public IndividualCostumer (
            Long id,
            String name,
            String email,
            List<Telephone> telephones,
            List<Advertisement> advertisements,
            String CPF
    ) {
        super(id, name, email, telephones, advertisements);
        this.CPF = CPF;
    }

    public IndividualCostumer (
            String name,
            String email,
            String CPF,
            List<Telephone> telephones,
            List<Advertisement> advertisements

    ) {
        super(name, email, telephones, advertisements);
        CPF = Optional.ofNullable(CPF).orElseThrow(() -> new CustomerException("CPF must be informed"));
        this.CPF = CPF;
    }

    public IndividualCostumer() {
        super();
    }

    public String getCPF() {
        return CPF;
    }

    private void validateCPF() {}

}
