package com.wyden.findyourhome.dto;

import com.wyden.findyourhome.entities.enums.PropertyType;

public class CreatePropertyDTO {
    private String address;
    private Integer rooms;
    private Integer bathrooms;
    private Integer privateParkingSpace;
    private Double taxes;
    private Double fee;
    private Double area;
    private PropertyType type;

    public CreatePropertyDTO(String address, Integer rooms, Integer bathrooms, Integer privateParkingSpace, Double taxes, Double fee, Double area, PropertyType type) {
        this.address = address;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.privateParkingSpace = privateParkingSpace;
        this.taxes = taxes;
        this.fee = fee;
        this.area = area;
        this.type = type;
    }

    public String getAddress() {
        return address;
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
