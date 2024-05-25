package com.wyden.findyourhome.dto;


public class UpdateCostumerDTO {

    private final Long id;
    private final String name;
    private final String email;

    public UpdateCostumerDTO(
        Long id, 
        String name, 
        String email
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
