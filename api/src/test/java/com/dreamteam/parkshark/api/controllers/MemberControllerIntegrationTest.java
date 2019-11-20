package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.SimplifiedMemberDto;
import com.dreamteam.parkshark.api.dtos.MemberDto;
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
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
@Sql(scripts = "classpath:clear-rows.sql")
class MemberControllerIntegrationTest {
    private static final String POST_PATH = MemberController.PATH + "/register";
    @Value("${server.port}") private int port;

    @BeforeEach
    void setUp() {
        TestObjects.initialize();
    }

    @Test
    @DisplayName("when creating a user with all necessary fields, 201 is returned along with the UserDto")
    void createSuccesfully() {
        var returnedDto = requestToCreateMember()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .as(MemberDto.class);

        memberDto.id = returnedDto.id;
        assertEquals(memberDto, returnedDto);
    }

    @Test
    @DisplayName("when creating a user with fields missing, 400 is returned along with an informative message")
    void createIncomplete() {
        createMemberDto.firstName = null;
        createMemberDto.address.postalCode = null;

        var errorMessage = requestToCreateMember()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .body()
                .as(ErrorMessage.class)
                .message;

        assertTrue(errorMessage.contains("first name required")
                || errorMessage.contains("last name required"));
    }

    @Test
    @DisplayName("when creating a user with invalid email, 400 is returned along with an informative message")
    void createWithInvalidEmail() {
        createMemberDto.emailAddress = "invalid";
        var errorMessage = requestToCreateMember()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .response()
                .body()
                .as(ErrorMessage.class)
                .message;
        assertEquals("invalid email format", errorMessage);
    }

    @Test
    @Sql(scripts = { "classpath:insert-address.sql","classpath:insert-member.sql"})
    void getAllDtos(){
        var simplifiedMemberDto = RestAssured
                .given()
                .contentType(JSON)
                .when()
                .port(port)
                .get(MemberController.PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath()
                .getList(".", SimplifiedMemberDto.class);

        Assertions.assertThat(simplifiedMemberDto)
                .contains(TestObjects.simplifiedMemberDto);

    }

    private Response requestToCreateMember() {
        return RestAssured
                .given()
                .accept(JSON)
                .contentType(JSON)
                .body(createMemberDto)
                .when()
                .port(port)
                .post(POST_PATH);
    }
}