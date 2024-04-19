package com.wyden.findyourhome.dto;

import com.wyden.findyourhome.entities.enums.PropertyType;

public class UpdatePropertyDTO {
    private final Long id;
    private final String address;
    private final Integer rooms;
    private final Integer bathrooms;
    private final Integer privateParkingSpace;
    private final Double taxes;
    private final Double fee;
    private final Double area;

    public UpdatePropertyDTO(Long id, String address, Integer rooms, Integer bathrooms, Integer privateParkingSpace, Double taxes, Double fee, Double area) {
        this.id = id;
        this.address = address;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.privateParkingSpace = privateParkingSpace;
        this.taxes = taxes;
        this.fee = fee;
        this.area = area;
    }

    public Long getId() {
        return id;
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
}
