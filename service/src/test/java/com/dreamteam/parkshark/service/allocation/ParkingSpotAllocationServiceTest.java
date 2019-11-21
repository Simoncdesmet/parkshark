package com.dreamteam.parkshark.service.allocation;

import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.domain.allocation.Status;
import com.dreamteam.parkshark.service.member.MemberService;
import com.dreamteam.parkshark.service.parkinglot.ParkingLotService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureTestDatabase
@EntityScan(basePackages = "com.dreamteam.parkshark")
class ParkingSpotAllocationServiceTest {

    @Autowired
    private ParkingSpotAllocationService allocationService;

    private ParkingSpotAllocation allocation;


    @BeforeEach
    void setUp() {
        allocation = new ParkingSpotAllocation(
                999,
                "1-225-198",
                "999");
    }


    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenCreatingAllocationWithValidInformation_persistedObjectIsReturned() {
        assertEquals(allocation, allocationService.startParkingAllocation(allocation));
    }

    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenCreatingAllocationWithWrongMemberId_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> allocationService.startParkingAllocation(
                        new ParkingSpotAllocation(
                                998,
                                "1-225-198",
                                "999"))
        );
    }

    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenCreatingAllocationWithWrongLicensePlateNumber_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> allocationService.startParkingAllocation(
                        new ParkingSpotAllocation(
                                999,
                                "1-225-197",
                                "999"))
        );
    }

    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenCreatingAllocationWithWrongLicensePlateNumberButMembershipLevelIsGold_noExceptionIsThrown() {
        assertDoesNotThrow(
                () -> allocationService.startParkingAllocation(
                        new ParkingSpotAllocation(
                                1000,
                                "1-225-197",
                                "999"))
        );
    }

    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenCreatingAllocationWithWrongParkingLotId_throwIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class,
                () -> allocationService.startParkingAllocation(
                        new ParkingSpotAllocation(
                                999,
                                "1-225-198",
                                "998"))
        );
    }

    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenCreatingAllocationWithFullParkingLot_throwIllegalArgumentException() {
        allocationService.startParkingAllocation(allocation);
        assertThrows(IllegalArgumentException.class,
                () -> allocationService.startParkingAllocation(allocation));
    }

    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenStoppingAllocationAsMember_allocationStatusIsPassive() {
        allocationService.startParkingAllocation(allocation);
        assertEquals(
                Status.STOPPED,
                allocationService
                        .stopParkingAllocation(allocation.getExternalId(), 999)
                        .getStatus()
        );
    }


    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenStoppingAllocationAsWrongMember_returnsException() {
        allocationService.startParkingAllocation(allocation);
        assertThrows(IllegalArgumentException.class,
                () -> allocationService
                        .stopParkingAllocation(allocation.getExternalId(), 998)
        );
    }


    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenStoppingAllocationWithInvalidId_returnsException() {
        allocationService.startParkingAllocation(allocation);
        assertThrows(IllegalArgumentException.class,
                () -> allocationService
                        .stopParkingAllocation("998", 999));
    }


    @Sql(scripts = "classpath:delete-rows.sql")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenStoppingAllocation_returnsAllocationWithStopTimeStamp() {
        allocationService.startParkingAllocation(allocation);
        assertNotNull(
                allocationService
                        .stopParkingAllocation(allocation.getExternalId(), 999)
                        .getStopTime()
        );
    }
}
