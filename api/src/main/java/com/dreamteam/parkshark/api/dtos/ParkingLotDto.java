package com.dreamteam.parkshark.api.dtos;

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
}
