package com.wyden.findyourhome.dto;

public class CreateTelephoneDTO {

    private Long customerId;
    private String number;
    private boolean mainNumber;


    public CreateTelephoneDTO(
        Long customerId,
        String number,
        boolean mainNumber
    ) {
        this.customerId = customerId;
        this.number = number;
        this.mainNumber = mainNumber;
    }


    public String getNumber() {
        return number;
    }

    public boolean getMainNumber() {
        return mainNumber;
    }


    public Long getCustomerId() {
        return this.customerId;
    }

}
