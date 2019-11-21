package com.dreamteam.parkshark.api.dtos;

import com.dreamteam.parkshark.api.dtos.validation.ExistingDivisionId;

import javax.validation.constraints.NotNull;

public class CreateDivisionDto {
    @NotNull
    public String name;
    @NotNull
    public String originalName;
    @NotNull
    public String directorName;
    @ExistingDivisionId
    public String parentDivisionId;
}
