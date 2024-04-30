package com.wyden.findyourhome.dto;
import java.util.Objects;


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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UpdateCustomerDTO) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.cpf, that.cpf) &&
                Objects.equals(this.cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, cpf, cnpj);
    }

    @Override
    public String toString() {
        return "UpdateCustomerDTO[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "email=" + email + ", " +
                "cpf=" + cpf + ", " +
                "cnpj=" + cnpj + "]" ;
    }

}
