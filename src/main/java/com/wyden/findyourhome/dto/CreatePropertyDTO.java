package com.wyden.findyourhome.dto;

import com.wyden.findyourhome.entities.enums.PropertyType;

public class CreatePropertyDTO {
    private String street;
    private String state;
    private String zipCode;
    private String neighborhood;
    private String city;
    private Integer rooms;
    private Integer bathrooms;
    private Integer privateParkingSpace;
    private Double taxes;
    private Double fee;
    private Double area;
    private PropertyType type;

    public CreatePropertyDTO(
            String street,
            String state,
            String zipCode,
            String neighborhood,
            String city,
            Integer rooms,
            Integer bathrooms,
            Integer privateParkingSpace,
            Double taxes,
            Double fee,
            Double area,
            PropertyType type
    ) {
        this.street = street;
        this.state = state;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
        this.city = city;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.privateParkingSpace = privateParkingSpace;
        this.taxes = taxes;
        this.fee = fee;
        this.area = area;
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public Integer getRooms() {
        return rooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public Integer getPrivateParkingSpace() {
        return privateParkingSpace;
    }

    public Double getTaxes() {
        return taxes;
    }

    public Double getFee() {
        return fee;
    }

    public Double getArea() {
        return area;
    }

    public PropertyType getType() {
        return type;
    }
}
