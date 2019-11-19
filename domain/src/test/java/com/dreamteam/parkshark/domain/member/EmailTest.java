package com.dreamteam.parkshark.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @Test
    @DisplayName("A valid email address gets created without any thrown exceptions")
    void valid() {
        assertDoesNotThrow(() -> new Email("valid@email.com"));
    }

    @Test
    @DisplayName("An email address can't be null")
    void notNull() {
        assertThrows(NullPointerException.class, () -> new Email(null));
    }

    @Test
    @DisplayName("An email address can't be empty")
    void notEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
    }

    @Test
    @DisplayName("An email address must contain @")
    void mustContainAt() {
        assertThrows(IllegalArgumentException.class, () -> new Email("prefix.gmail.com"));
    }

    @Test
    @DisplayName("An email address must contain a dot")
    void mustContainDot() {
        assertThrows(IllegalArgumentException.class, () -> new Email("prefix@gmail@com"));
    }

    @Test
    @DisplayName("An email address must contain an @ before a dot")
    void mustContainAtBeforeDot() {
        assertThrows(IllegalArgumentException.class, () -> new Email("prefix.gmail@com"));
    }
}