package com.dreamteam.parkshark.api.dtos;

import java.time.LocalDateTime;

public class CreateParkingSpotAllocationDto {

    private long memberId;
    private String licensePlateNumber;
    private String parkingLotId;

    public CreateParkingSpotAllocationDto(long memberId, String licensePlateNumber, String parkingLotId) {
        this.memberId = memberId;
        this.licensePlateNumber = licensePlateNumber;
        this.parkingLotId = parkingLotId;
    }

    public CreateParkingSpotAllocationDto withMemberId(long memberId) {
        this.memberId = memberId;
        return this;
    }

    public CreateParkingSpotAllocationDto withLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
        return this;
    }

    public CreateParkingSpotAllocationDto withParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
        return this;
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



}
