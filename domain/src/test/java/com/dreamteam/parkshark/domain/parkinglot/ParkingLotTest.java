package com.dreamteam.parkshark.domain.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingLotTest {


    @Test
    void givenNoPhoneNumbers_whenCreatingContactPerson_ExceptionIsThrown() {

        Address address = new Address("straat", "nummer", "3000","Leuven");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new ContactPerson("hans",
                    "vanhansegem",
                    null,
                    null, "simoncdesmet@gmail.com", address);
        });
    }


    @Test
    void givenValidPhoneNumber_whenCreatingContactPerson_PersonIsCreated() {
        Address address = new Address("straat", "nummer", "3000", "Leuven");

        Assertions.assertDoesNotThrow(()->
        {
            new ContactPerson("hans",
                    "vanhansegem",
                    "1111",
                    null, "simoncdesmet@gmail.com", address);
        });
    }


    @Test
    void givenInvalidEmailAddress_whenCreatingContactPerson_ExceptionIsThrown() {

        Address address = new Address("straat", "nummer","3000", "Leuven");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new ContactPerson("hans",
                    "vanhansegem",
                    "1111",
                    null, "email", address);
        });
    }


    @Test
    void givenValidEmailAddress_whenCreatingContactPerson_PersonIsCreated() {
        Address address = new Address("straat", "nummer", "3000", "Leuven");

        Assertions.assertDoesNotThrow(()->
        {
            new ContactPerson("hans",
                    "vanhansegem",
                    "1111",
                    null, "simoncdesmet@gmail.com", address);
        });
    }
}