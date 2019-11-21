package com.dreamteam.parkshark.api.mapper;

import com.dreamteam.parkshark.api.dtos.CreateParkingSpotAllocationDto;
import com.dreamteam.parkshark.api.dtos.ParkingSpotAllocationDto;
import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import org.springframework.stereotype.Component;

@Component
public class AllocationDtoMapper {

    public ParkingSpotAllocation toAllocation(CreateParkingSpotAllocationDto allocationDto) {
        return new ParkingSpotAllocation(
                allocationDto.getMemberId(),
                allocationDto.getLicensePlateNumber(),
                allocationDto.getParkingLotId()
        );
    }


    public ParkingSpotAllocationDto toDto(ParkingSpotAllocation allocation) {
        return new ParkingSpotAllocationDto()
                .withExternalId(allocation.getExternalId())
                .withLicensePlateNumber(allocation.getLicensePlateNumber())
                .withMemberId(allocation.getMemberId())
                .withParkingLotId(allocation.getParkingLotId())
                .withStartTime(allocation.getStartTime())
                .withStopTime(allocation.getStopTime())
                .withStatus(allocation.getStatus());
    }
}
