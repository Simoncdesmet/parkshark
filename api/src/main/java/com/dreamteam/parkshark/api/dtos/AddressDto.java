package com.dreamteam.parkshark.api.dtos;

import java.util.Objects;

public class AddressDto {
    public String city;
    public String postalCode;
    public String streetName;
    public String streetNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(city, that.city) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(streetName, that.streetName) &&
                Objects.equals(streetNumber, that.streetNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, postalCode, streetName, streetNumber);
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }
}
