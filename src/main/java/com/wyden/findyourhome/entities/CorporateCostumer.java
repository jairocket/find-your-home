package com.wyden.findyourhome.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wyden.findyourhome.exceptions.CostumerException;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@DiscriminatorValue("1")
public class CorporateCostumer extends Costumer {
    @Column(unique = true)
    private String CNPJ;
    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL)
    private List<Telephone> telephones;
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL)
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

    public CorporateCostumer(
            String name,
            String email,
            List<Telephone> telephones,
            List<Advertisement> advertisements,
            String CNPJ
    ) {
        super(name, email);
        validateCnpj(CNPJ);
        this.advertisements = advertisements;
        this.CNPJ = CNPJ;
        this.telephones = telephones;
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

    private void validateCnpj(String cnpj) {
        cnpj = Optional.ofNullable(cnpj).orElseThrow(() -> new CostumerException("É preciso informar o CNPJ"));
        Pattern cnpjPattern = Pattern.compile("[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}");
        Matcher cnpjMatcher = cnpjPattern.matcher(cnpj);

        if(!cnpjMatcher.matches()) {
            throw new CostumerException("CNPJ inválido.");
        }

    }
}
