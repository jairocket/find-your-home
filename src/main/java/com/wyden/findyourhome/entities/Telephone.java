package com.wyden.findyourhome.entities;

import jakarta.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TELEPHONE")
public class Telephone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Costumer customer;

    @Column(name = "number")
    private String number;

    @Column(name = "main_number")
    private boolean mainNumber;

    public Telephone(
        Costumer customer,
        String number,
        boolean mainNumber
    ) {
        this.customer = customer;
        this.number = number;
        this.mainNumber = mainNumber;
    }

    public Telephone() {
    }

    public Long getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getMainNumber() {
        return this.mainNumber;
    }

    public void setMainNumber(boolean mainNumber) {
        this.mainNumber = mainNumber;
    }

    public Costumer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Costumer customer) {
        this.customer = customer;
    }

}