package com.wyden.findyourhome.dto;

import com.wyden.findyourhome.entities.Advertisement;
import com.wyden.findyourhome.entities.Telephone;

import java.util.ArrayList;
import java.util.List;

public class CreateIndividualCustomerDTO {
    private String name;
    private String email;
    private String cpf;
    private List<Advertisement> advertisements = new ArrayList<>();
    private List<Telephone> telephones = new ArrayList<>();

    public CreateIndividualCustomerDTO(
            String name,
            String email,
            String cpf,
            List<Telephone> telephones
    ) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.telephones = telephones;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }
}
