package com.dreamteam.parkshark.service.allocation;

import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import com.dreamteam.parkshark.repository.ParkingSpotAllocationRepository;
import com.dreamteam.parkshark.service.parkinglot.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotValidator {

    private final ParkingLotService parkingLotService;
    private final ParkingSpotAllocationRepository allocationRepository;

    @Autowired
    public ParkingLotValidator(ParkingLotService parkingLotService, ParkingSpotAllocationRepository allocationRepository) {
        this.parkingLotService = parkingLotService;
        this.allocationRepository = allocationRepository;
    }

    public void validateParkingLot(ParkingSpotAllocation allocation) {
        ParkingLot parkingLot = getParkingLot(allocation);
        checkParkingLotCapacity(parkingLot);
    }


    private ParkingLot getParkingLot(ParkingSpotAllocation allocation) {
        return parkingLotService.getParkingLotByExternalId(allocation.getParkingLotId());
    }

    private void checkParkingLotCapacity(ParkingLot parkingLot) {
        if (parkingLot.getMaxCapacity() <= allocationRepository.findByParkingLotId(parkingLot.getExternalId())
                .size()) {
            throw new IllegalArgumentException("Parking lot is full!");
        }
    }
}
