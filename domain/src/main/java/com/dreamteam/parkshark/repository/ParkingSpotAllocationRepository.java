package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingSpotAllocationRepository extends CrudRepository<ParkingSpotAllocation, Long> {

    List<ParkingSpotAllocation> findAll();

    Optional<ParkingSpotAllocation> findByExternalId(String externalId);

    List<ParkingSpotAllocation> findByParkingLotId(String parkingLotId);
}