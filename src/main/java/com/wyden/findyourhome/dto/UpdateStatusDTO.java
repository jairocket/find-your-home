package com.wyden.findyourhome.dto;

public class UpdateStatusDTO {
     private final Long id;
     private final String status;

    public UpdateStatusDTO(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
