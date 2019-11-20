package com.dreamteam.parkshark.api.dtos;

import java.util.Objects;

public class SingleParkingLotDto {

    private String externalId;
    private String name;
    private int maxCapacity;
    private long pricePerHour;
    private ContactPersonDto contactPersonDto;
    private AddressDto addressDto;
    private String category;
    private DivisionDto divisionDto;

    public SingleParkingLotDto withExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public SingleParkingLotDto withName(String name) {
        this.name = name;
        return this;
    }

    public SingleParkingLotDto withMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public SingleParkingLotDto withPricePerHour(long pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    public SingleParkingLotDto withContactPersonDto(ContactPersonDto contactPersonDto) {
        this.contactPersonDto = contactPersonDto;
        return this;
    }

    public SingleParkingLotDto withAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public SingleParkingLotDto withCategory(String category) {
        this.category = category;
        return this;
    }

    public SingleParkingLotDto withDivisionDto(DivisionDto divisionDto){
        this.divisionDto = divisionDto;
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

    public DivisionDto getDivisionDto() { return divisionDto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleParkingLotDto that = (SingleParkingLotDto) o;
        return maxCapacity == that.maxCapacity &&
                pricePerHour == that.pricePerHour &&
                Objects.equals(externalId, that.externalId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(contactPersonDto, that.contactPersonDto) &&
                Objects.equals(addressDto, that.addressDto) &&
                Objects.equals(category, that.category) &&
                Objects.equals(divisionDto, that.divisionDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId, name, maxCapacity, pricePerHour, contactPersonDto, addressDto, category, divisionDto);
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
                ", divisionDto='" + divisionDto + '\'' +
                '}';
    }
}
