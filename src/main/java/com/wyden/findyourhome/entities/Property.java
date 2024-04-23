package com.wyden.findyourhome.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyden.findyourhome.entities.enums.PropertyType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PROPERTY")
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Address address;
    private Integer rooms;
    private Integer bathrooms;
    @Column(name = "private_parking_space")
    private Integer privateParkingSpace;
    private Double taxes;
    private Double fee;
    private Double area;
    private PropertyType type;

    public Property(
            Address address,
            Integer rooms,
            Integer bathrooms,
            Integer privateParkingSpace,
            Double taxes,
            Double fee,
            Double area,
            PropertyType type
    ) {
        this.address = address;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.privateParkingSpace = privateParkingSpace;
        this.taxes = taxes;
        this.fee = fee;
        this.area = area;
        this.type = type;
    }

    public Property() {
    }

    public Long getId() {
        return id;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getPrivateParkingSpace() {
        return privateParkingSpace;
    }

    public void setPrivateParkingSpace(Integer privateParkingSpace) {
        this.privateParkingSpace = privateParkingSpace;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public PropertyType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(getId(), property.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
