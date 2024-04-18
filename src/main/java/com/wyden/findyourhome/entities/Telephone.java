package com.wyden.findyourhome.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "TELEPHONE")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "main_number")
    private boolean mainNumber;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


    public Telephone(
        int id, 
        String number, 
        boolean mainNumber, 
        Person person
    ) {
        this.id = id;
        this.number = number;
        this.mainNumber = mainNumber;
        this.person = person;
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

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
