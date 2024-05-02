package com.wyden.findyourhome.entities;

import com.wyden.findyourhome.exceptions.CustomerException;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity(name = "CORPORATE_CUSTOMER")
public class CorporateCostumer extends AbstractCostumer {
    private String CNPJ;

    public CorporateCostumer (
            Long id,
            String name,
            String email,
            List<Telephone> telephones,
            List<Advertisement> advertisements,
            String CNPJ
    ) {
        super(id, name, email, telephones, advertisements);
        CNPJ = Optional.ofNullable(CNPJ).orElseThrow(() -> new CustomerException("CNPJ must be informed"));
        this.CNPJ = CNPJ;
    }

    public CorporateCostumer() {
        super();
    }

    public String getCNPJ() {
        return CNPJ;
    }

    private void validateCNPJ(String CNPJ) {

    }

}
