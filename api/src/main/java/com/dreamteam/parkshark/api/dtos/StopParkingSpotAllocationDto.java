package com.dreamteam.parkshark.api.dtos;

public class StopParkingSpotAllocationDto {

    private String allocationExternalId;
    private long memberId;

    public StopParkingSpotAllocationDto() {
    }

    public StopParkingSpotAllocationDto(String allocationExternalId, long memberId) {
        this.allocationExternalId = allocationExternalId;
        this.memberId = memberId;
    }

    public String getAllocationExternalId() {
        return allocationExternalId;
    }

    public long getMemberId() {
        return memberId;
    }


}
