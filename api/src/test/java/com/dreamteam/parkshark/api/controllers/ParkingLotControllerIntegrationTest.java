package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.AddressDto;
import com.dreamteam.parkshark.api.dtos.ContactPersonDto;
import com.dreamteam.parkshark.api.dtos.CreateParkingLotDto;
import com.dreamteam.parkshark.api.dtos.ParkingLotDto;
import com.dreamteam.parkshark.api.mapper.ParkingLotDtoMapper;
import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
class ParkingLotControllerIntegrationTest {

    private static final String PATH = "/parkinglots";
    @Value("${server.port}")
    private int port;

    @Autowired
    private ParkingLotDtoMapper parkingLotDtoMapper;

    @Test
    @DisplayName("when creating a parking lot with all necessary fields, 201 is returned along with the ParkingLotDto")
    void createSuccesfully() {
        ParkingLot parkingLot = createParkingLotObject();
        CreateParkingLotDto createParkingLotDto = parkingLotDtoMapper.toCreateParkingLotDto(parkingLot);

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
                .as(ParkingLotDto.class);

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
        assertEquals(getTestParkingLotDto(), parkingLotDtos.get(0));
        assertTrue(parkingLotDtos.contains(getTestParkingLotDto()));
    }

    private ParkingLot createParkingLotObject() {
        Address address = new Address("Leuven", "3000", "Straat", "3");
        ContactPerson contactPerson = new ContactPerson(
                "Jos",
                "Verhoeven",
                "0487577040",
                null,
                "josverhoeven@gmail.com", address);
        return new ParkingLot(
                "lot1",
                Category.UNDERGROUND,
                1000,
                contactPerson,
                address,
                2000);
    }

    private CreateParkingLotDto createParkingLotDtoWithoutPhoneNumber() {
        AddressDto addressDto = new AddressDto()
                .withCity("Leuven")
                .withPostalCode("3000")
                .withStreetName("Straat")
                .withStreetNumber("3A");
        ContactPersonDto contactPersonDto = new ContactPersonDto()
                .withFirstName("Jos")
                .withLastName("Verhoeven")
                .withEmail("simoncdesmet@mgail.com")
                .withAddress(addressDto);

        return new CreateParkingLotDto()
                .withName("Name")
                .withCategory("UNDERGROUND")
                .withContactPersonDto(contactPersonDto)
                .withAddressDto(addressDto)
                .withMaxCapacity(1000)
                .withPricePerHour(10);
    }

    private ParkingLotDto getTestParkingLotDto() {
        AddressDto addressDto = new AddressDto()
                .withCity("Leuven")
                .withPostalCode("3000")
                .withStreetName("Straat")
                .withStreetNumber("3A");
        ContactPersonDto contactPersonDto = new ContactPersonDto()
                .withFirstName("Jos")
                .withLastName("Verhoeven")
                .withPhoneNumber("0516846513")
                .withEmail("simoncdesmet@mgail.com")
                .withAddress(addressDto);

        return new ParkingLotDto()
                .withExternalId("999")
                .withName("Name")
                .withCategory("UNDERGROUND")
                .withContactPersonDto(contactPersonDto)
                .withAddressDto(addressDto)
                .withMaxCapacity(1000)
                .withPricePerHour(10);
    }
}