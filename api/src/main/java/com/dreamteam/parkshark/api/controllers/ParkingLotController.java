package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.CreateParkingLotDto;
import com.dreamteam.parkshark.api.dtos.ParkingLotDto;
import com.dreamteam.parkshark.api.dtos.SingleParkingLotDto;
import com.dreamteam.parkshark.api.mapper.ParkingLotDtoMapper;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import com.dreamteam.parkshark.service.parkinglot.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "parkinglots")

public class ParkingLotController {

    private final ParkingLotDtoMapper parkingLotDtoMapper;
    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotDtoMapper parkingLotDtoMapper, ParkingLotService parkingLotService) {
        this.parkingLotDtoMapper = parkingLotDtoMapper;
        this.parkingLotService = parkingLotService;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
        ParkingLot parkingLotToCreate = parkingLotDtoMapper.toParkingLot(createParkingLotDto);
        parkingLotService.createParkingLot(parkingLotToCreate);
        return parkingLotDtoMapper.toCreateParkingLotDto(parkingLotToCreate);
    }

    @GetMapping
    public List<ParkingLotDto> getAll() {
        return parkingLotDtoMapper.toParkingLotDtos(parkingLotService.getAll());
    }



}
