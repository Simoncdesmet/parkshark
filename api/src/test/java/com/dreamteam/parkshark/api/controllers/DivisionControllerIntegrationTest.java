package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.DivisionDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static com.dreamteam.parkshark.api.controllers.TestObjects.*;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
public class DivisionControllerIntegrationTest {
    private static final String POST_PATH = DivisionController.PATH + "/create";
    @Value("${server.port}") private int port;

    @BeforeEach
    void setUp() {
        TestObjects.initialize();
    }

    @Test
    @DisplayName("when creating a division, 201 is returned along with the dto")
    void createSuccesfully(){
        var returnedDto = requestToCreateMember()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .as(DivisionDto.class);

        divisionDto.id = returnedDto.id;
        assertEquals(divisionDto, returnedDto);
    }

    private Response requestToCreateMember() {
        return RestAssured
                .given()
                .accept(JSON)
                .contentType(JSON)
                .body(createDivisionDto)
                .when()
                .port(port)
                .post(POST_PATH);
    }
}
