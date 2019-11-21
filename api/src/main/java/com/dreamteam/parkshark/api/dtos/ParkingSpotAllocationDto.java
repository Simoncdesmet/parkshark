package com.dreamteam.parkshark.api.dtos;

import com.dreamteam.parkshark.domain.allocation.Status;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ParkingSpotAllocationDto {


    private String externalId;
    private long memberId;
    private String licensePlateNumber;
    private String parkingLotId;
    private LocalDateTime startTime;
    private LocalDateTime stopTime;
    private Status status;

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

    public ParkingSpotAllocationDto withStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
        return this;
    }

    public ParkingSpotAllocationDto withStatus(Status status) {
        this.status = status;
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

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public Status getStatus() {
        return status;
    }
}
