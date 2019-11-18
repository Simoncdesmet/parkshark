package com.dreamteam.parkshark.service.parkinglot;

import com.dreamteam.parkshark.domain.parkinglot.Address;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import com.dreamteam.parkshark.repository.parkinglot.ParkingLotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
class ParkingLotServiceTest {

    @Autowired
    private ParkingLotService parkingLotService;

    private ParkingLot parkingLot;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @BeforeEach
    void setUp() {
        Address address = new Address("Straat", "nummer", "3000", "Leuven");
        ContactPerson contactPerson = new ContactPerson(
                "Jos",
                "Verhoeven",
                "0487577040",
                null,
                "josverhoeven@gmail.com", address);
        parkingLot = new ParkingLot(
                "lot1",
                Category.UNDERGROUND,
                1000,
                contactPerson,
                address,
                2000);
    }

    @Test
    void givenParkingLot_whenSavingParkingLot_ParkingLotIsSaved() {
        parkingLotService.createParkingLot(parkingLot);

    }
}