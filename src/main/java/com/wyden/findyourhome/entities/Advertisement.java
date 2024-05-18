package com.wyden.findyourhome.entities;
import jakarta.persistence.*;

import com.wyden.findyourhome.entities.enums.AdvertisementStatus;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "ADVERTISEMENT")
public class Advertisement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    private AdvertisementStatus status;

    @OneToOne
    @MapsId
    private Property property;

    private Instant postDate;

    private Double value;

    private Instant soldIn;

    private String description;

    public Advertisement(
            Costumer costumer,
            AdvertisementStatus status,
            Property property,
            Instant postDate,
            Double value,
            Instant soldIn,
            String description
    ) {

        this.costumer = costumer;
        this.status = status;
        this.property = property;
        this.postDate = postDate;
        this.value = value;
        this.soldIn = soldIn;
        this.description = description;
    }

    public Advertisement(){}

    public Advertisement(
            Long id,
            Costumer costumer,
            AdvertisementStatus status,
            Property property,
            Instant postDate,
            Double value,
            Instant soldIn,
            String description
    ) {

        this.id = id;
        this.costumer = costumer;
        this.status = status;
        this.property = property;
        this.postDate = postDate;
        this.value = value;
        this.soldIn = soldIn;
        this.description = description;

    }

    public Long getId() {
        return this.id;
    }

    public Costumer getCostumer() {
        return this.costumer;
    }

    public AdvertisementStatus getStatus() {
        return this.status;
    }

    public void setStatus(AdvertisementStatus status) {
        this.status = status;
    }

    public Property getProperty() {
        return this.property;
    }

    public Instant getPostDate() {
        return this.postDate;
    }

    public void setPostDate(Instant postDate) {
        this.postDate = postDate;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Instant getSoldIn() {
        return this.soldIn;
    }

    public void setSoldId(Instant soldIn) {
        this.soldIn = soldIn;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
