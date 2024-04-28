package com.wyden.findyourhome.dto;

import java.util.Objects;

public final class UpdatePropertyDTO {
    private final Long id;
    private final Integer rooms;
    private final Integer bathrooms;
    private final Integer privateParkingSpace;
    private final Double taxes;
    private final Double fee;
    private final Double area;

    public UpdatePropertyDTO(
            Long id,
            Integer rooms,
            Integer bathrooms,
            Integer privateParkingSpace,
            Double taxes,
            Double fee,
            Double area
    ) {
        this.id = id;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.privateParkingSpace = privateParkingSpace;
        this.taxes = taxes;
        this.fee = fee;
        this.area = area;
    }

    public Long id() {
        return id;
    }

    public Integer rooms() {
        return rooms;
    }

    public Integer bathrooms() {
        return bathrooms;
    }

    public Integer privateParkingSpace() {
        return privateParkingSpace;
    }

    public Double taxes() {
        return taxes;
    }

    public Double fee() {
        return fee;
    }

    public Double area() {
        return area;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UpdatePropertyDTO) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.rooms, that.rooms) &&
                Objects.equals(this.bathrooms, that.bathrooms) &&
                Objects.equals(this.privateParkingSpace, that.privateParkingSpace) &&
                Objects.equals(this.taxes, that.taxes) &&
                Objects.equals(this.fee, that.fee) &&
                Objects.equals(this.area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rooms, bathrooms, privateParkingSpace, taxes, fee, area);
    }

    @Override
    public String toString() {
        return "UpdatePropertyDTO[" +
                "id=" + id + ", " +
                "rooms=" + rooms + ", " +
                "bathrooms=" + bathrooms + ", " +
                "privateParkingSpace=" + privateParkingSpace + ", " +
                "taxes=" + taxes + ", " +
                "fee=" + fee + ", " +
                "area=" + area + ']';
    }

}
