package com.dreamteam.parkshark.api.dtos;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ParkingSpotAllocationDto {


    private String externalId;
    private long memberId;
    private String licensePlateNumber;
    private String parkingLotId;
    private LocalDateTime startTime;


    public ParkingSpotAllocationDto withExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public ParkingSpotAllocationDto withMemberId(long memberId) {
        this.memberId = memberId;
        return this;
    }

    public ParkingSpotAllocationDto withLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
        return this;
    }

    public ParkingSpotAllocationDto withParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
        return this;
    }

    public ParkingSpotAllocationDto withStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
