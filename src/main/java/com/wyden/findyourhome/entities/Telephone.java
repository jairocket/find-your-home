package com.wyden.findyourhome.entities;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TELEPHONE")
public class Telephone implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "custumer_id")
    private Customer customer;

    @Column(name = "number")
    private String number;

    @Column(name = "main_number")
    private boolean mainNumber;


    public Telephone(
        int id, 
        String number, 
        boolean mainNumber, 
        Customer customer
    ) {
        this.id = id;
        this.number = number;
        this.mainNumber = mainNumber;
        this.customer = customer;
    }


    public Telephone() {
    }


    public int getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isMainNumber() {
        return this.mainNumber;
    }

    public boolean getMainNumber() {
        return this.mainNumber;
    }

    public void setMainNumber(boolean mainNumber) {
        this.mainNumber = mainNumber;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}