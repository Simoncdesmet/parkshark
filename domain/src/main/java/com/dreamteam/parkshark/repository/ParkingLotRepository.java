package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {

    List<ParkingLot> findAll();

    Optional<ParkingLot> findByExternalId(String externalId);

}