package com.dreamteam.parkshark.api.dtos;

public class CreateParkingLotDto {

    private String name;
    private int maxCapacity;
    private long pricePerHour;
    private ContactPersonDto contactPersonDto;
    private AddressDto addressDto;
    private String category;

    public CreateParkingLotDto withName(String name) {
        this.name = name;
        return this;
    }

    public CreateParkingLotDto withMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public CreateParkingLotDto withPricePerHour(long pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    public CreateParkingLotDto withContactPersonDto(ContactPersonDto contactPersonDto) {
        this.contactPersonDto = contactPersonDto;
        return this;
    }

    public CreateParkingLotDto withAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public CreateParkingLotDto withCategory(String category) {
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
}
