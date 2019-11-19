package com.dreamteam.parkshark.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddressTest {
    private static final String STREET_NAME = "streetName";
    private static final String STREET_NUMBER = "streetNumber";
    private static final String POSTAL_CODE = "postalCode";

    @Test
    @DisplayName("A valid address gets created without any thrown exceptions")
    void valid() {
        assertDoesNotThrow(() -> addressWithCity("valid city"));
    }

    @Test
    @DisplayName("An address can't be null")
    void notNull() {
        assertThrows(IllegalArgumentException.class, () -> addressWithCity(null));
    }

    @Test
    @DisplayName("An address can't be empty")
    void notEmpty() {
        assertThrows(IllegalArgumentException.class, () -> addressWithCity(""));
    }

    private Address addressWithCity(String city) {
        return Address.newBuilder()
                .withStreetNumber(STREET_NUMBER)
                .withStreetName(STREET_NAME)
                .withPostalCode(POSTAL_CODE)
                .withCity(city)
                .build();
    }
}