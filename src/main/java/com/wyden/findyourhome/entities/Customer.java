package com.wyden.findyourhome.entities;

import jakarta.persistence.*;
import java.util.List;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Custumer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;
    private String email;
    private String phone;

    private String cpf;
    private String cnpj;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Telephone> telephones;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    public Customer(
          Integer id, 
          String name, 
          String email, 
          String phone, 
          String cpf, 
          String cnpj, 
          List<Telephone> telephones, 
          List<Advertisement> advertisements
     ){
          this.id = id;
          this.name = name;
          this.email = email;
          this.phone = phone;
          this.cpf = cpf;
          this.telephones = telephones;
          this.advertisements = advertisements;
     }

    public Customer() {
    }

    public int getId() {
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
