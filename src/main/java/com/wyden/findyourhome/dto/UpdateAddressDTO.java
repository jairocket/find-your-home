package com.wyden.findyourhome.dto;

public class UpdateAddressDTO {
    private String street;
    private String state;
    private String zipCode;
    private String neighborhood;
    private String city;

    public UpdateAddressDTO(String street, String state, String zipCode, String neighborhood, String city) {
        this.street = street;
        this.state = state;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
        this.city = city;
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
}
