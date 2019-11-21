package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.CreateParkingSpotAllocationDto;
import com.dreamteam.parkshark.api.dtos.ParkingSpotAllocationDto;
import com.dreamteam.parkshark.api.dtos.StopParkingSpotAllocationDto;
import com.dreamteam.parkshark.api.mapper.AllocationDtoMapper;
import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.service.allocation.ParkingSpotAllocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ParkingSpotAllocationDto startAllocation(@RequestBody CreateParkingSpotAllocationDto createAllocationDto) {
        ParkingSpotAllocation allocationToCreate = allocationDtoMapper.toAllocation(createAllocationDto);
        return allocationDtoMapper.toDto(allocationService.startParkingAllocation(allocationToCreate));}

    @DeleteMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ParkingSpotAllocationDto stopAllocation(@RequestBody StopParkingSpotAllocationDto stopAllocationDto) {
        return allocationDtoMapper.toDto(
                allocationService.stopParkingAllocation(
                        stopAllocationDto.getAllocationExternalId(),
                        stopAllocationDto.getMemberId()));
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingSpotAllocationDto> getAllAllocations(@RequestParam(name = "number", required = false) String number,
                                       @RequestParam(name = "order", required = false) String order,
                                       @RequestParam(name = "status", required = false) String status){
        List<ParkingSpotAllocationDto> finalList = new ArrayList<>();
        for (ParkingSpotAllocation spot : allocationService.getAllAllocations(number, order, status)){
            finalList.add(allocationDtoMapper.toDto(spot));
        }
        return finalList;
    }

    @GetMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingSpotAllocationDto> getAllAllocationsByMember(@PathVariable("id") String id, @RequestParam(name = "status", required = false) String status){
        List<ParkingSpotAllocationDto> finalList = new ArrayList<>();
        for (ParkingSpotAllocation spot : allocationService.getAllocationsForAGivenMember(id, status)){
            finalList.add(allocationDtoMapper.toDto(spot));
        }
        return finalList;
    }
}
