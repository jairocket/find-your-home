package com.wyden.findyourhome.dto;

public class DeleteAdvertisementImageDTO {
    public final Long advertisementId;
    public final String imageName;

    public DeleteAdvertisementImageDTO(Long advertisementId, String imageName) {
        this.advertisementId = advertisementId;
        this.imageName = imageName;
    }
}
