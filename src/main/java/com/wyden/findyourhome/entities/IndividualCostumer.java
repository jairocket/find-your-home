package com.wyden.findyourhome.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "INDIVIDUAL_CUSTOMERS")
public class IndividualCostumer extends AbstractCostumer {
    private String CPF;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Telephone> telephones;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    public IndividualCostumer (
            Long id,
            String name,
            String email,
            List<Telephone> telephones,
            List<Advertisement> advertisements,
            String CPF
    ) {
        super(id, name, email);
        this.CPF = CPF;
        this.telephones = telephones;
        this.advertisements = advertisements;
    }

    public IndividualCostumer (
            String name,
            String email,
            List<Telephone> telephones,
            List<Advertisement> advertisements,
            String CPF
    ) {
        super(name, email);
        this.CPF = CPF;
        this.telephones = telephones;
        this.advertisements = advertisements;
    }

    public IndividualCostumer() {
        super();
    }

    public String getCPF() {
        return CPF;
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
