package com.wyden.findyourhome.dto;

import com.wyden.findyourhome.entities.Costumer;
import com.wyden.findyourhome.entities.Property;
import com.wyden.findyourhome.entities.enums.AdvertisementStatus;

import java.time.Instant;

public class CreateAdvertisementDTO {
    Long costumerId;
    String status;
    Long propertyId;
    Double value;
    String description;

    public CreateAdvertisementDTO(
            Long costumerId,
            String description,
            Long propertyId,
            String status,
            Double value
    ) {
        this.costumerId = costumerId;
        this.description = description;
        this.propertyId = propertyId;
        this.status = status;
        this.value = value;
    }

    public Long getCostumerId() {
        return costumerId;
    }
    public String getDescription() {
        return description;
    }

    public Long getProperty() {
        return propertyId;
    }

    public String getStatus() {
        return status;
    }

    public Double getValue() {
        return value;
    }
}
