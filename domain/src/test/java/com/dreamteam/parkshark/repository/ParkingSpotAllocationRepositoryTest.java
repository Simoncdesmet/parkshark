package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
class ParkingSpotAllocationRepositoryTest {

    @Autowired
    private ParkingSpotAllocationRepository repository;

    private ParkingSpotAllocation allocation;

    @BeforeEach
    void setUp() {

        allocation = new ParkingSpotAllocation(
                123,
                "123-1211-1",
                "12348");

    }

    @Test
    @DisplayName("an allocation object remains the same after persisting")
    void basicFunctionality1() {
        var persistedAllocation = repository.save(allocation);
        assertEquals(allocation, persistedAllocation);
    }

    @Test
    @DisplayName("an allocation object remains the same after persisting and retrieving")
    void basicFunctionality2() {
        var persistedAllocation = repository.save(allocation);
        var retrievedAllocation = repository.findByExternalId(persistedAllocation.getExternalId());
        assertEquals(allocation, retrievedAllocation.orElseThrow());
    }
}