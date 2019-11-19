package com.dreamteam.parkshark.api.mapper;

import com.dreamteam.parkshark.api.dtos.*;
import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.division.Division;
import com.dreamteam.parkshark.domain.member.LicencePlate;
import com.dreamteam.parkshark.domain.member.Member;
import org.springframework.stereotype.Component;

import javax.lang.model.element.ModuleElement;

@Component
public class Mapper {
    public Member toMember(CreateMemberDto dto){
        var licencePlate = new LicencePlate(dto.licencePlateNumber, dto.licencePlateCountry);
        return Member.newBuilder()
                .withFirstName(dto.firstName)
                .withLastName(dto.lastName)
                .withEmailAdress(dto.emailAdress)
                .withTelephoneNumber(dto.telephoneNumber)
                .withAddress(toAddress(dto.address))
                .withLicencePlate(licencePlate)
                .build();
    }

    public MemberDto toDto(Member member){
        MemberDto memberDto = new MemberDto();
        memberDto.id = member.getId();
        memberDto.firstName = member.getFirstName();
        memberDto.lastName = member.getLastName();
        memberDto.address = toDto(member.getAddress());
        memberDto.emailAdress = member.getEmailAdress().getAddress();
        memberDto.telephoneNumber = member.getTelephoneNumber();
        memberDto.licencePlateNumber = member.getLicencePlate().getNumber();
        memberDto.licencePlateCountry = member.getLicencePlate().getCountry();
        memberDto.registrationDate = member.getRegistrationDate();
        return memberDto;
    }

    private AddressDto toDto(Address address) {
        var dto = new AddressDto();
        dto.city = address.getCity();
        dto.postalCode = address.getPostalCode();
        dto.streetName = address.getStreetName();
        dto.streetNumber = address.getStreetNumber();
        return dto;
    }

    private Address toAddress(AddressDto dto) {
        return Address.newBuilder()
                .withStreetNumber(dto.streetNumber)
                .withStreetName(dto.streetName)
                .withPostalCode(dto.postalCode)
                .withCity(dto.city)
                .build();
    }

    public Division toDivision(CreateDivisionDto dto){
        return new Division(dto.name, dto.originalName, dto.directorName);
    }

    public DivisionDto toDto (Division division){
        DivisionDto divisionDto = new DivisionDto();
        divisionDto.name = division.getName();
        divisionDto.directorName = division.getDirectorName();
        divisionDto.originalName = division.getOriginalName();
        return divisionDto;
    }
}
