package com.wyden.findyourhome.dto;

public class CreateAdvertisementDTO {
    Long costumerId;
    Long propertyId;
    Double value;
    String description;

    public CreateAdvertisementDTO(
            Long costumerId,
            String description,
            Long propertyId,
            Double value
    ) {
        this.costumerId = costumerId;
        this.description = description;
        this.propertyId = propertyId;
        this.value = value;
    }

    public Long getCostumerId() {
        return costumerId;
    }
    public String getDescription() {
        return description;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public Double getValue() {
        return value;
    }
}
