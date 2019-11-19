package com.dreamteam.parkshark.api.dtos;

import java.util.Objects;

public class ParkingLotDto {

    private String externalId;
    private String name;
    private int maxCapacity;
    private long pricePerHour;
    private ContactPersonDto contactPersonDto;
    private AddressDto addressDto;
    private String category;

    public ParkingLotDto withExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public ParkingLotDto withName(String name) {
        this.name = name;
        return this;
    }

    public ParkingLotDto withMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public ParkingLotDto withPricePerHour(long pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    public ParkingLotDto withContactPersonDto(ContactPersonDto contactPersonDto) {
        this.contactPersonDto = contactPersonDto;
        return this;
    }

    public ParkingLotDto withAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public ParkingLotDto withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public long getPricePerHour() {
        return pricePerHour;
    }

    public ContactPersonDto getContactPersonDto() {
        return contactPersonDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public String getCategory() {
        return category;
    }

    public String getExternalId() {
        return externalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLotDto that = (ParkingLotDto) o;
        return maxCapacity == that.maxCapacity &&
                pricePerHour == that.pricePerHour &&
                Objects.equals(externalId, that.externalId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(contactPersonDto, that.contactPersonDto) &&
                Objects.equals(addressDto, that.addressDto) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId, name, maxCapacity, pricePerHour, contactPersonDto, addressDto, category);
    }

    @Override
    public String toString() {
        return "ParkingLotDto{" +
                "externalId='" + externalId + '\'' +
                ", name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", pricePerHour=" + pricePerHour +
                ", contactPersonDto=" + contactPersonDto +
                ", addressDto=" + addressDto +
                ", category='" + category + '\'' +
                '}';
    }
}
