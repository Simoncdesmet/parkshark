package com.dreamteam.parkshark.service.parkinglot;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import com.dreamteam.parkshark.repository.ParkingLotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingLotServiceUnitTest {
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
    private ParkingLotService parkingLotService;

    @BeforeEach
    void setUp(){
        ParkingLotRepository repository = mock(ParkingLotRepository.class);
        when(repository.save(PARKING_LOT))
                .thenReturn(PARKING_LOT);
        when(repository.findAll())
                .thenReturn(List.of(PARKING_LOT));
        when(repository.findById(PARKING_LOT.getId()))
                .thenReturn(Optional.of(PARKING_LOT));
        parkingLotService = new ParkingLotService(repository);
    }

    @Test
    @DisplayName("getting a parking lot by id returns an optional containing the expected parking lot")
    void getADivision() {
        assertEquals(
                PARKING_LOT,
                parkingLotService.getById(PARKING_LOT.getId())
                        .orElseThrow()
        );
    }
}
