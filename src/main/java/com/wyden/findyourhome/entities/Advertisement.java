package com.wyden.findyourhome.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wyden.findyourhome.exceptions.AdvertisementException;
import jakarta.persistence.*;

import com.wyden.findyourhome.entities.enums.AdvertisementStatus;
import org.apache.commons.math3.util.Precision;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "ADVERTISEMENTS")
public class Advertisement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    private AdvertisementStatus status;

    @OneToOne
    @MapsId
    private Property property;

    private Instant postedIn;

    private Double value;

    private Instant soldIn;

    private String description;

    private List<String> images;

    public Advertisement(
            Costumer costumer,
            AdvertisementStatus status,
            Property property,
            Instant postedIn,
            Double value,
            Instant soldIn,
            String description
    ) {
        validateConstructor(costumer, property);
        this.costumer = costumer;
        this.status = status;
        this.property = property;
        this.postedIn = postedIn;
        this.value = round(value);
        this.soldIn = soldIn;
        this.description = description;
        this.images = new ArrayList<>();
    }

    public Advertisement(){}

    public Advertisement(
            Long id,
            Costumer costumer,
            AdvertisementStatus status,
            Property property,
            Instant postedIn,
            Double value,
            Instant soldIn,
            String description,
            List<String> images
    ) {

        this.id = id;
        this.costumer = costumer;
        this.status = status;
        this.property = property;
        this.postedIn = postedIn;
        this.value = round(value);
        this.soldIn = soldIn;
        this.description = description;
        this.images = images;
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

    public Instant getPostedIn() {
        return this.postedIn;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = round(value);
    }

    public Instant getSoldIn() {
        return this.soldIn;
    }

    public void setSoldIn(Instant soldIn) {
        this.soldIn = soldIn;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    private void validateConstructor(Costumer costumer, Property property) {
        Optional.ofNullable(costumer).orElseThrow(() -> new AdvertisementException("Cliente não encontrado"));
        Optional.ofNullable(property).orElseThrow(() -> new AdvertisementException("Imóvel não encontrado"));
    }

    private Double round(Double value) {
        value = Optional.ofNullable(value).orElseThrow(()-> new AdvertisementException("Valor não pode ser nulo"));
        return Precision.round(value, 2);
    }
}
