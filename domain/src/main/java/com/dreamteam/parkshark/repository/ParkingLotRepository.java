package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {

    List<ParkingLot> findAll();

}