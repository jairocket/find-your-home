package com.wyden.findyourhome.dto;

import java.util.List;

public class CreateIndividualCustomerDTO {

    private String name;
    private String email;
    private String phone;
    private String cpf;
    private List<CreateTelephoneDTO> telephones;

    public CreateIndividualCustomerDTO(
            String name,
            String email,
            String cpf,
            List<CreateTelephoneDTO> telephones
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

    public List<CreateTelephoneDTO> getTelephones() {
        return telephones;
    }
}
