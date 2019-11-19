package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.*;
import com.dreamteam.parkshark.domain.division.Division;

import java.time.LocalDate;

public class TestObjects {
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL_ADDRESS = "valid@address.com";
    public static final String CITY = "city";
    public static final String POSTAL_CODE = "postalCode";
    public static final String STREET_NAME = "streetName";
    public static final String STREET_NUMBER = "streetNumber";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String LICENCE_PLATE_NUMBER = "number";
    public static final String LICENCE_PLATE_COUNTRY = "country";
    public static final AddressDto addressDto = new AddressDto();
    public static final MemberDto memberDto = new MemberDto();
    public static final CreateMemberDto createMemberDto = new CreateMemberDto();

    public static final String DIVISION_NAME = "divName";
    public static final String DIVISION_ORIGINAL_NAME = "original name";
    public static final String DIRECTOR_NAME = "director name";
    public static final DivisionDto divisionDto = new DivisionDto();
    public static final CreateDivisionDto createDivisionDto = new CreateDivisionDto();

    public static void initialize() {
        addressDto.postalCode = POSTAL_CODE;
        addressDto.streetNumber = STREET_NUMBER;
        addressDto.streetName = STREET_NAME;
        addressDto.city = CITY;

        memberDto.firstName = FIRST_NAME;
        memberDto.lastName = LAST_NAME;
        memberDto.telephoneNumber = PHONE_NUMBER;
        memberDto.emailAdress = EMAIL_ADDRESS;
        memberDto.address = addressDto;
        memberDto.licencePlateNumber = LICENCE_PLATE_NUMBER;
        memberDto.licencePlateCountry = LICENCE_PLATE_COUNTRY;
        memberDto.registrationDate = LocalDate.now();

        createMemberDto.firstName = FIRST_NAME;
        createMemberDto.lastName = LAST_NAME;
        createMemberDto.telephoneNumber = PHONE_NUMBER;
        createMemberDto.emailAdress = EMAIL_ADDRESS;
        createMemberDto.address = addressDto;
        createMemberDto.licencePlateNumber = LICENCE_PLATE_NUMBER;
        createMemberDto.licencePlateCountry = LICENCE_PLATE_COUNTRY;

        createDivisionDto.name = DIVISION_NAME;
        createDivisionDto.originalName = DIVISION_ORIGINAL_NAME;
        createDivisionDto.directorName = DIRECTOR_NAME;

        divisionDto.name = DIVISION_NAME;
        divisionDto.originalName = DIVISION_ORIGINAL_NAME;
        divisionDto.directorName = DIRECTOR_NAME;
    }
}
