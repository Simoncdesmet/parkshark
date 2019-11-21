package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.CreateParkingSpotAllocationDto;
import com.dreamteam.parkshark.api.dtos.ParkingSpotAllocationDto;
import com.dreamteam.parkshark.api.mapper.AllocationDtoMapper;
import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.service.allocation.ParkingSpotAllocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "park")
public class AllocationController {

private final ParkingSpotAllocationService allocationService;
private final AllocationDtoMapper allocationDtoMapper;
    public AllocationController(ParkingSpotAllocationService allocationService, AllocationDtoMapper allocationDtoMapper) {
        this.allocationService = allocationService;
        this.allocationDtoMapper = allocationDtoMapper;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSpotAllocationDto createAllocation(@RequestBody CreateParkingSpotAllocationDto createAllocationDto) {
        ParkingSpotAllocation allocationToCreate = allocationDtoMapper.toAllocation(createAllocationDto);
        return allocationDtoMapper.toDto(allocationService.createAllocation(allocationToCreate));
    }
}
