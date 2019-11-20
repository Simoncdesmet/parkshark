package com.dreamteam.parkshark.service.allocation;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.domain.member.Email;
import com.dreamteam.parkshark.domain.member.LicencePlate;
import com.dreamteam.parkshark.domain.member.Member;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import com.dreamteam.parkshark.service.MemberService;
import com.dreamteam.parkshark.service.parkinglot.ParkingLotService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


@SpringBootTest
@AutoConfigureTestDatabase
@EntityScan(basePackages = "com.dreamteam.parkshark")
class ParkingSpotAllocationServiceTest {

    @Autowired
    private ParkingSpotAllocationService allocationService;

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private MemberService memberService;

    private ParkingSpotAllocation allocation;


    @BeforeEach
    void setUp() {
        allocation = new ParkingSpotAllocation(
                999,
                "1-225-198",
                "999");
    }


    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")

    @Test
    void whenCreatingAllocationWithValidInformation_persistedObjectIsReturned() {
        Assertions.assertEquals(allocation, allocationService.createAllocation(allocation));
    }

    @Test
    void whenCreatingAllocationWithWrongMemberId_throwIllegalArgumentException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> allocationService.createAllocation(
                new ParkingSpotAllocation(
                        998,
                        "1-225-198",
                        "999)"
                )
                )
        );
    }

    @Test
    void whenCreatingAllocationWithWrongLicensePlateNumber_throwIllegalArgumentException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> allocationService.createAllocation(
                new ParkingSpotAllocation(
                        999,
                        "1-225-197",
                        "999)"
                )
                )
        );
    }


    @Test
    void whenCreatingAllocationWithWrongParkingLotIdr_throwIllegalArgumentException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> allocationService.createAllocation(
                new ParkingSpotAllocation(
                        999,
                        "1-225-198",
                        "998)"
                )
                )
        );
    }

    @Test
    void whenCreatingAllocationWithFullParkingLot_throwIllegalArgumentException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> allocationService.createAllocation(allocation));
    }

}