package com.dreamteam.parkshark.api.dtos;

import java.util.Objects;

public class ParkingLotDto {
    private String externalId;
    private String name;
    private int maxCapacity;
    private SimplifiedContactDto contactPersonDto;

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

    public ParkingLotDto withContactPersonDto(SimplifiedContactDto contactPersonDto) {
        this.contactPersonDto = contactPersonDto;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public SimplifiedContactDto getContactPersonDto() {
        return contactPersonDto;
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
                Objects.equals(externalId, that.externalId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(contactPersonDto, that.contactPersonDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId, name, maxCapacity, contactPersonDto);
    }

    @Override
    public String toString() {
        return "ParkingLotDto{" +
                "externalId='" + externalId + '\'' +
                ", name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", contactPersonDto=" + contactPersonDto +
                '}';
    }
}
