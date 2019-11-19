package com.dreamteam.parkshark.api.mapper;

import com.dreamteam.parkshark.api.dtos.CreateDivisionDto;
import com.dreamteam.parkshark.api.dtos.DivisionDto;
import com.dreamteam.parkshark.domain.division.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionDtoMapper {

    public Division toDivision(CreateDivisionDto dto){
        return new Division(dto.name, dto.originalName, dto.directorName);
    }

    public DivisionDto toDto (Division division){
        DivisionDto divisionDto = new DivisionDto();
        divisionDto.id = division.getId();
        divisionDto.name = division.getName();
        divisionDto.directorName = division.getDirectorName();
        divisionDto.originalName = division.getOriginalName();
        return divisionDto;
    }
}
