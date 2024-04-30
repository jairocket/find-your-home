package com.wyden.findyourhome.dto;

import java.util.List;

public class CreateCustomerDTO {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private String cnpj;
    private List<CreateTelephoneDTO> telephones;

    public CreateCustomerDTO(
            String name,
            String email,
            String phone,
            String cpf,
            String cnpj,
            List<CreateTelephoneDTO> telephones) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.telephones = telephones;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<CreateTelephoneDTO> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<CreateTelephoneDTO> telephones) {
        this.telephones = telephones;
    }
}
