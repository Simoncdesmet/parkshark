package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.CreateDivisionDto;
import com.dreamteam.parkshark.api.dtos.DivisionDto;
import com.dreamteam.parkshark.api.mapper.DivisionDtoMapper;
import com.dreamteam.parkshark.domain.division.Division;
import com.dreamteam.parkshark.service.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = DivisionController.PATH)
public class DivisionController {
    public static final String PATH = "division";
    private DivisionService divisionService;
    private DivisionDtoMapper mapper;

    @Autowired
    public DivisionController(DivisionService divisionService, DivisionDtoMapper mapper) {
        this.divisionService = divisionService;
        this.mapper = mapper;
    }

    @PostMapping (path = "/create", produces = "application/json", consumes = "application/json")
    @ResponseStatus (HttpStatus.CREATED)
    public DivisionDto create(@RequestBody @Valid CreateDivisionDto createDivisionDto){
        var divisionToCreate = mapper.toDivision(createDivisionDto);
        var createdDivision = divisionService.createDivision(divisionToCreate);
        return mapper.toDto(createdDivision);
    }

    @GetMapping("{id}")
    public DivisionDto getById(@PathVariable long id) {
        var division = divisionService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("division does not exist"));
        return mapper.toDto(division);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDto> getAll(){
        List<DivisionDto> listDto = new ArrayList<>();
        for (Division division : divisionService.getAll()){
            listDto.add(mapper.toDto(division));
        }
        return listDto;
    }
}
