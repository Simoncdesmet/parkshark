package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.*;
import com.dreamteam.parkshark.api.mapper.ParkingLotDtoMapper;
import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static com.dreamteam.parkshark.api.controllers.TestObjects.*;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@Sql(scripts = "classpath:clear-rows.sql")
class ParkingLotControllerIntegrationTest {

    private static final String PATH = "/parkinglots";
    @Value("${server.port}")
    private int port;

    @BeforeEach
    void setUp() {
        TestObjects.initialize();
    }

    @Test
    @DisplayName("when creating a parking lot with all necessary fields, 201 is returned along with the ParkingLotDto")
    void createSuccesfully() {
        var returnedDto = RestAssured
                .given()
                .accept(JSON)
                .contentType(JSON)
                .body(createParkingLotDto)
                .when()
                .port(port)
                .post(PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .as(CreateParkingLotDto.class);

        assertEquals(createParkingLotDto.getName(), returnedDto.getName());
        assertEquals(createParkingLotDto.getAddressDto(), returnedDto.getAddressDto());
        assertEquals(createParkingLotDto.getContactPersonDto(), returnedDto.getContactPersonDto());
    }

    @Test
    @DisplayName("when creating a parking lot with no phone number in contact person, 400 is returned along with exception message")
    void createWrongly() {
        CreateParkingLotDto createParkingLotDto = createParkingLotDtoWithoutPhoneNumber();

        var result = RestAssured
                .given()
                .accept(JSON)
                .contentType(JSON)
                .body(createParkingLotDto)
                .when()
                .port(port)
                .post(PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .body()
                .asString();

        assertTrue(result.contains("Please provide at least one phone number."));
    }

    @Test
    @Sql(scripts = {"classpath:insert-address.sql", "classpath:insert-parkinglot.sql"})
    @DisplayName("when performing a get request on 'parking lot', you receive a list of parkingLotDtos")
    void getAll() {
        var parkingLotDtos = RestAssured
                .given()
                .contentType(JSON)
                .when()
                .port(port)
                .get(PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath()
                .getList(".", ParkingLotDto.class);
        assertTrue(parkingLotDtos.contains(parkingLotDto));
//        assertTrue(parkingLotDtos.contains(getTestParkingLotDto()));
    }

    private CreateParkingLotDto createParkingLotDtoWithoutPhoneNumber() {
        return createParkingLotDto
                .withContactPersonDto(
                        contactPersonDto
                                .withMobilePhoneNumber(null)
                                .withPhoneNumber(null));
    }

    private ParkingLotDto getTestParkingLotDto() {
        AddressDto addressDto = new AddressDto()
                .withCity("Leuven")
                .withPostalCode("3000")
                .withStreetName("Straat")
                .withStreetNumber("3A");
        SimplifiedContactDto contactPersonDto = new SimplifiedContactDto()
                .withMobilePhoneNumber("0473689541")
                .withPhoneNumber("0516846513")
                .withEmail("simoncdesmet@mgail.com");

        return new ParkingLotDto()
                .withExternalId("999")
                .withName("name")
                .withContactPersonDto(contactPersonDto)
                .withMaxCapacity(1000);
    }
}