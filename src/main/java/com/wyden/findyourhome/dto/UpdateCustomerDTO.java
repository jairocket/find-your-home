package com.wyden.findyourhome.dto;


public class UpdateCustomerDTO {

    private final Long id;
    private final String name;
    private final String email;
    private final String cpf;
    private final String cnpj;

    public UpdateCustomerDTO(
        Long id, 
        String name, 
        String email, 
        String cpf, 
        String cnpj
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
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

    public String getCnpj() {
        return cnpj;
    }
}
