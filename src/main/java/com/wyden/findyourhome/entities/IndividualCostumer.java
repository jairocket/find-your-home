package com.wyden.findyourhome.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wyden.findyourhome.exceptions.CostumerException;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@DiscriminatorValue("2")
public class IndividualCostumer extends Costumer {
    @Column(unique = true)
    private String CPF;

    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL)
    private List<Telephone> telephones;

    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL)
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
        validateCpf(CPF);

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

    private void validateCpf(String cpf) {
        cpf = Optional.ofNullable(cpf).orElseThrow(() -> new CostumerException("É preciso informar o CPF"));
        Pattern cpfPattern = Pattern.compile("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}");
        Matcher cpfMatcher = cpfPattern.matcher(cpf);

        if(!cpfMatcher.matches()) {
            throw new CostumerException("CPF inválido.");
        }

    }
}
