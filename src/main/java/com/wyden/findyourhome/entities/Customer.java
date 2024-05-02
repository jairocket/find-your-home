package com.wyden.findyourhome.entities;

import jakarta.persistence.*;
import java.util.List;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String cnpj;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Telephone> telephones;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    public Customer(
        String name,
        String email,
        String cpf,
        String cnpj,
        List<Telephone> telephones,
        List<Advertisement> advertisements
    ) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.telephones = telephones;
        this.advertisements = advertisements;
    }

    public Customer() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telephone> getTelephones() {
        return this.telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Advertisement> getAdvertisements() {
        return this.advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
