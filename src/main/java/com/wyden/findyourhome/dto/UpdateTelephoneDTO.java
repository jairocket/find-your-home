package com.wyden.findyourhome.dto;

public class UpdateTelephoneDTO {

    private Long id;
    private String number;
    private boolean mainNumber;
    

    public UpdateTelephoneDTO() {
    }

    public UpdateTelephoneDTO(
        String number,
        boolean mainNumber
    ) {
        this.number = number;
        this.mainNumber = mainNumber;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public boolean getMainNumber() {
        return mainNumber;
    }
}
