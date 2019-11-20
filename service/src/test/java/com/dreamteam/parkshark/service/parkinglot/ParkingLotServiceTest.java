package com.dreamteam.parkshark.service.parkinglot;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.division.Division;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import com.dreamteam.parkshark.repository.ParkingLotRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureTestDatabase
@EntityScan(basePackages = "com.dreamteam.parkshark")
class ParkingLotServiceTest {

    @Autowired
    private ParkingLotService parkingLotService;

    private ParkingLot parkingLot;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @BeforeEach
    void setUp() {
        Address address = new Address("Leuven", "3000", "Straat", "3");
        ContactPerson contactPerson = new ContactPerson(
                "Jos",
                "Verhoeven",
                "0487577040",
                null,
                "josverhoeven@gmail.com", address);
        Division divsion = new Division(1,"SharkyPark", "Blue Parking", "Jos V.");
        parkingLot = new ParkingLot(
                "lot1",
                Category.UNDERGROUND,
                1000,
                contactPerson,
                address,
                2000,
                1);
    }

    @Test
    void givenParkingLot_whenSavingParkingLot_ParkingLotIsSaved() {
        parkingLotService.createParkingLot(parkingLot);
        Assertions.assertTrue(parkingLotRepository.findAll()
                .stream()
                .map(ParkingLot::getExternalId)
                .collect(Collectors.toList())
                .contains(parkingLot.getExternalId()));
        Assertions.assertEquals(1, parkingLotRepository.findAll()
                .size());
    }


}