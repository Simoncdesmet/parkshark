package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.CreateParkingSpotAllocationDto;
import com.dreamteam.parkshark.api.dtos.ParkingSpotAllocationDto;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static com.dreamteam.parkshark.api.controllers.TestObjects.divisionDto;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
public class AllocationControllerIntegrationTest {

    private static final String PATH = "/park";
    @Value("${server.port}")
    private int port;

    private CreateParkingSpotAllocationDto createAllocationDto;

    @BeforeEach
    void setUp() {
        createAllocationDto = new CreateParkingSpotAllocationDto(
                999,
                "1-225-198",
                "999");
    }

    @Test
    @DisplayName("when creating an allocation, 201 is returned along with the dto")
    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    void createSuccesfully() {

        var returnedDto =
                RestAssured
                        .given()
                        .accept(JSON)
                        .contentType(JSON)
                        .body(createAllocationDto)
                        .when()
                        .port(port)
                        .post(PATH)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.SC_CREATED)
                        .extract()
                        .body()
                        .as(ParkingSpotAllocationDto.class);

        assertEquals(createAllocationDto.getLicensePlateNumber(), returnedDto.getLicensePlateNumber());
        assertEquals(createAllocationDto.getParkingLotId(), returnedDto.getParkingLotId());
        assertEquals(createAllocationDto.getMemberId(), returnedDto.getMemberId());
        assertNotNull(returnedDto.getStartTime());
    }

    @Test
    @DisplayName("when creating an allocation with unknown memberId, 400 is returned along with member not found message")
    void createWithUnknownMember() {

        CreateParkingSpotAllocationDto allocationWithUnknownMemberId = new CreateParkingSpotAllocationDto(
                998,
                "1-225-198",
                "999");

        var result =
                RestAssured
                        .given()
                        .accept(JSON)
                        .contentType(JSON)
                        .body(allocationWithUnknownMemberId)
                        .when()
                        .port(port)
                        .post(PATH)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.SC_BAD_REQUEST)
                        .extract()
                        .body()
                        .asString();

        Assertions.assertTrue(result.contains("No member found with this id!"));
    }
}
