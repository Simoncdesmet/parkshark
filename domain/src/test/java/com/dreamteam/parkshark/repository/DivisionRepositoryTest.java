package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.division.Division;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
public class DivisionRepositoryTest {
    private static final Division DIVISION = new Division(
            "name",
            "originalName",
            "directorName");

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    @DisplayName("a division remains the same after persisting")
    void basicFunctionality1(){
        var persistedDivision = divisionRepository.save(DIVISION);
        assertEquals(DIVISION, persistedDivision);
    }

    @Test
    @DisplayName("a division remains the same after persisting and retrieving")
    void basicFunctionality2(){
        var persistedDivision = divisionRepository.save(DIVISION);
        var retrievedDivision = divisionRepository.findById(persistedDivision.getId());
        assertEquals(DIVISION, retrievedDivision.orElseThrow());
    }

}
