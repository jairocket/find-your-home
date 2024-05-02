package com.wyden.findyourhome.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "CORPORATE_CUSTOMERS")
public class CorporateCostumer extends AbstractCostumer {
    private String CNPJ;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Telephone> telephones;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    public CorporateCostumer (
            Long id,
            String name,
            String email,
            List<Telephone> telephones,
            List<Advertisement> advertisements,
            String CNPJ
    ) {
        super(id, name, email);
        this.CNPJ = CNPJ;
        this.telephones = telephones;
        this.advertisements = advertisements;
    }

    public CorporateCostumer() {
        super();
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

}
