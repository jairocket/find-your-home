package com.wyden.findyourhome.entities;

import com.wyden.findyourhome.exceptions.CustomerException;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Optional;

@Entity(name = "COSTUMERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "costumer_type", discriminatorType = DiscriminatorType.INTEGER)
public class Costumer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;

    public Costumer(
            Long id,
            String name,
            String email
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Costumer(String name, String email) {
        validateEmail(email);
        this.name = name;
        this.email = email;
    }

    public Costumer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void validateEmail(String email) {
        Optional.ofNullable(email).orElseThrow(()-> new CustomerException("Email precisa ser informado."));
    }

}
