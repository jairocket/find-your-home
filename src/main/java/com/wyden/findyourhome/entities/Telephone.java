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

    @Column(name = "number")
    private String number;

    @Column(name = "main_number")
    private boolean mainNumber;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;


    public Telephone(
        int id, 
        String number, 
        boolean mainNumber, 
        Costumer costumer
    ) {
        this.id = id;
        this.number = number;
        this.mainNumber = mainNumber;
        this.costumer = costumer;
    }


    public Telephone() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Costumer getCostumer() {
        return this.costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }


}
