package com.dreamteam.parkshark.service.parkinglot;

import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import com.dreamteam.parkshark.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public void createParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }

    public List<ParkingLot> getAll() {
        return parkingLotRepository.findAll();
    }
}
