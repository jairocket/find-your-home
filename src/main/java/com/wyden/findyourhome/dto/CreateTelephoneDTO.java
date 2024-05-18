package com.wyden.findyourhome.dto;

public class CreateTelephoneDTO {

    private Long costumerId;
    private String number;
    private boolean mainNumber;


    public CreateTelephoneDTO(
        Long costumerId,
        String number,
        boolean mainNumber
    ) {
        this.costumerId = costumerId;
        this.number = number;
        this.mainNumber = mainNumber;
    }


    public String getNumber() {
        return number;
    }

    public boolean getMainNumber() {
        return mainNumber;
    }


    public Long getCostumerId() {
        return this.costumerId;
    }

}
