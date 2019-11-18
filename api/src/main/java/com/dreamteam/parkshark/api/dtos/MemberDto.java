package com.dreamteam.parkshark.api.dtos;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.member.Email;
import com.dreamteam.parkshark.domain.member.LicencePlate;

import java.time.LocalDate;

public class MemberDto {
    public long id;
    public String lastName;
    public String firstName;
    public Address address;
    public String telephoneNumber;
    public Email emailAdress;
    public LicencePlate licencePlate;
    public LocalDate registrationDate;


}
