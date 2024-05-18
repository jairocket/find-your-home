package com.wyden.findyourhome.dto;

public class UpdateAdversementDTO {

    private final Long id;
    private final Double value;
    private final String description;

    public UpdateAdversementDTO(String description, Long id, String status, Double value) {
        this.description = description;
        this.id = id;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }
}
