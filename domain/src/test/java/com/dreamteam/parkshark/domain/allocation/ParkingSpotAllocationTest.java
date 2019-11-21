package com.dreamteam.parkshark.domain.allocation;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotAllocationTest {

    @Test
    void name() {
        List<String> list = List.of("HI","HELLO","TEST");

        System.out.println(list.stream().limit(5).collect(Collectors.toList()).toString());

    }
}