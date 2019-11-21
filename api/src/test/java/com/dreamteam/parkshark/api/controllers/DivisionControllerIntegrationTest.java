package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.DivisionDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static com.dreamteam.parkshark.api.controllers.TestObjects.*;

import static com.dreamteam.parkshark.api.controllers.TestObjects.createDivisionDto;
import static com.dreamteam.parkshark.api.controllers.TestObjects.divisionDto;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@Sql("classpath:clear-rows.sql")
class DivisionControllerIntegrationTest {
    private static final String POST_PATH = DivisionController.PATH + "/create";
    @Value("${server.port}") private int port;

    @BeforeEach
    void setUp() {
        TestObjects.initialize();
    }

    @Test
    @DisplayName("when creating a division, 201 is returned along with the dto")
    void createSuccesfully(){
        var returnedDto = requestToCreateDivisionWithoutParent()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .as(DivisionDto.class);

        divisionDto.id = returnedDto.id;

        assertEquals(divisionDto, returnedDto);
    }

    @Test
    @DisplayName("when creating a division with a parentId, 201 is returned along with the dto")
    @Sql(scripts = {"classpath:clear-rows.sql","classpath:insert-division.sql"})
    void createADivisionWithParentId(){
        var returnedDto = requestToCreateDivisionWithParent(String.valueOf(ID))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .as(DivisionDto.class);

        divisionDto.id = returnedDto.id;
        divisionDto.parentDivisionId = String.valueOf(ID);
        assertEquals(divisionDto, returnedDto);
    }

    @Test
    @DisplayName("when creating a division with an invalid parentId, 400 is returned along with a message")
    void createADivisionWithInvalidParentId(){
        var errorMessage = requestToCreateDivisionWithParent("test")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .body()
                .asString();
        Assertions.assertThat(errorMessage).contains("parent division does not exist");
    }

    @Test
    @DisplayName("when creating a division with a parentId that does not exist, 400 is returned along with a message")
    void createADivisionWithParentIdThatDoesNotExist(){
        createDivisionDto.parentDivisionId = "9123456";
        var errorMessage = requestToCreateDivisionWithParent("9123456")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .body()
                .asString();
        Assertions.assertThat(errorMessage).contains("parent division does not exist");
    }

    @Test
    @Sql(scripts = {"classpath:clear-rows.sql","classpath:insert-division.sql"})
    @Sql({"classpath:clear-rows.sql", "classpath:insert-division.sql"})
    void getAllDtos(){
        var divisionDtos = RestAssured
                .given()
                .contentType(JSON)
                .when()
                .port(port)
                .get(DivisionController.PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath()
                .getList(".", DivisionDto.class);
        assertTrue(divisionDtos.contains(divisionDto));
    }

    private Response requestToCreateDivisionWithoutParent() {
        createDivisionDto.parentDivisionId = null;
        return RestAssured
                .given()
                .accept(JSON)
                .contentType(JSON)
                .body(createDivisionDto)
                .when()
                .port(port)
                .post(POST_PATH);
    }

    private Response requestToCreateDivisionWithParent(String parentId) {
        createDivisionDto.parentDivisionId = parentId;
        return RestAssured
                .given()
                .accept(JSON)
                .contentType(JSON)
                .body(createDivisionDto)
                .when()
                .port(port)
                .post(POST_PATH);
    }

    @Test
    @DisplayName("when requesting a division by an existing id, 200 is returned along with the division's DTO")
    @Sql({"classpath:clear-rows.sql", "classpath:insert-division.sql"})
    void getById() {
        var returnedDto = RestAssured
                .given()
                .contentType(JSON)
                .when()
                .port(port)
                .get(DivisionController.PATH + '/' + ID)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(DivisionDto.class);
        assertEquals(divisionDto, returnedDto);
    }

    @Test
    @DisplayName("when requesting a division by an inexisting id, 400 is returned along with a message")
    @Sql({"classpath:clear-rows.sql", "classpath:insert-division.sql"})
    void getByNonExistantId() {
        var errorMessage = RestAssured
                .given()
                .contentType(JSON)
                .when()
                .port(port)
                .get(DivisionController.PATH + '/' + 42)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .body()
                .as(ErrorMessage.class);
        assertEquals("division does not exist", errorMessage.message);
    }

    @Test
    @DisplayName("when requesting a division by an invalid id, 400 is returned along with a message")
    @Sql({"classpath:clear-rows.sql", "classpath:insert-division.sql"})
    void getByInvalidId() {
        var errorMessage = RestAssured
                .given()
                .contentType(JSON)
                .when()
                .port(port)
                .get(DivisionController.PATH + "/invalid")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .body()
                .as(ErrorMessage.class);
        assertTrue(errorMessage.message.contains("Failed to convert"));
    }
}
