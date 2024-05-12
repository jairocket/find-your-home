package com.wyden.findyourhome.dto;

import com.wyden.findyourhome.entities.Advertisement;

import java.util.ArrayList;
import java.util.List;

public class CreateCorporateCustomerDTO {
    private String name;
    private String email;
    private String cnpj;
    private List<Advertisement> advertisements = new ArrayList<>();
    private List<CreateTelephoneDTO> telephones = new ArrayList<>();

    public CreateCorporateCustomerDTO(
            String name,
            String email,
            String cnpj,
            List<CreateTelephoneDTO> telephones
    ) {
        this.name = name;
        this.email = email;
        this.cnpj = cnpj;
        this.telephones = telephones;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<CreateTelephoneDTO> getTelephones() {
        return telephones;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }
}
