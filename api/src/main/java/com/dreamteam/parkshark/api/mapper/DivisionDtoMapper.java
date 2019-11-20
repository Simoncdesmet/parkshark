package com.dreamteam.parkshark.api.mapper;

import com.dreamteam.parkshark.api.dtos.CreateDivisionDto;
import com.dreamteam.parkshark.api.dtos.DivisionDto;
import com.dreamteam.parkshark.domain.division.Division;
import com.dreamteam.parkshark.service.division.DivisionService;
import org.springframework.stereotype.Component;

@Component
public class DivisionDtoMapper {
    private final DivisionService service;

    public DivisionDtoMapper(DivisionService service) {
        this.service = service;
    }

    public Division toDivision(CreateDivisionDto dto){
        if (dto.parentDivisionId != null) {
            var parent = service.getById(dto.parentDivisionId)
                    .orElseThrow(() -> new IllegalArgumentException("parent division does not exist"));
            return new Division(dto.name, dto.originalName, dto.directorName, parent);
        } else {
            return new Division(dto.name, dto.originalName, dto.directorName);
        }
    }

    public DivisionDto toDto (Division division){
        DivisionDto divisionDto = new DivisionDto();
        divisionDto.id = division.getId();
        divisionDto.name = division.getName();
        divisionDto.directorName = division.getDirectorName();
        divisionDto.originalName = division.getOriginalName();
        if (division.getParentDivision() != null) {
            divisionDto.parentDivisionId = String.valueOf(division.getParentDivision().getId());
        }
        return divisionDto;
    }
}
