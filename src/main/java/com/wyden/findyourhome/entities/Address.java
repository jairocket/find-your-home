package com.wyden.findyourhome.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyden.findyourhome.entities.Property;
import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Property property;
    private String street;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    private String neighborhood;
    private String city;


    public Address(
            Property property,
            String street,
            String state,
            String zipCode,
            String neighborhood,
            String city
    ) {

        this.property = property;
        this.street = street;
        this.state = state;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
        this.city = city;
    }


    public Address() {
    }


    public Long getId() {
        return this.id;
    }

    public Property getProperty() {
        return this.property;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}