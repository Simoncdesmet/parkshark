package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
class ParkingLotRepositoryTest {
    private static final Address ADDRESS = new Address(
            "city",
            "2000",
            "streetName",
            "1");
    private static final ContactPerson CONTACTPERSON = new ContactPerson(
            "firstName",
            "lastName",
            "0484277708",
            "032364499",
            "email@gmail.com",
            ADDRESS);
    private static final ParkingLot PARKING_LOT = new ParkingLot(
            "parkingLot",
            Category.ABOVEGROUND,
            123,
            CONTACTPERSON,
            ADDRESS,
            25,
            999);

    @Autowired
    private ParkingLotRepository parkingLotRepository;

}