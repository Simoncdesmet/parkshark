package com.dreamteam.parkshark.api.mapper;

import com.dreamteam.parkshark.api.dtos.CreateMemberDto;
import com.dreamteam.parkshark.api.dtos.SimplifiedMemberDto;
import com.dreamteam.parkshark.api.dtos.MemberDto;
import com.dreamteam.parkshark.domain.member.LicencePlate;
import com.dreamteam.parkshark.domain.member.Member;
import com.dreamteam.parkshark.domain.member.MembershipLevel;
import org.springframework.stereotype.Component;

@Component
public class MemberDtoMapper {

    private final AddressDtoMapper addressDtoMapper;

    public MemberDtoMapper(AddressDtoMapper addressDtoMapper) {
        this.addressDtoMapper = addressDtoMapper;
    }

    public Member toMember(CreateMemberDto dto) {
        var licencePlate = new LicencePlate(dto.licencePlateNumber, dto.licencePlateCountry);
        var memberBuilder = Member.newBuilder()
                .withFirstName(dto.firstName)
                .withLastName(dto.lastName)
                .withEmailAddress(dto.emailAddress)
                .withTelephoneNumber(dto.telephoneNumber)
                .withAddress(addressDtoMapper.toAddress(dto.address))
                .withLicencePlate(licencePlate);
        if (dto.memberShipLevel != null) {
            memberBuilder.withMemberShipLevel(MembershipLevel.valueOf(dto.memberShipLevel));
        }
        return memberBuilder.build();
    }

    public MemberDto toDto(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.id = member.getId();
        memberDto.firstName = member.getFirstName();
        memberDto.lastName = member.getLastName();
        memberDto.address = addressDtoMapper.toAddressDto(member.getAddress());
        memberDto.emailAddress = member.getEmailAddress().getAddress();
        memberDto.telephoneNumber = member.getTelephoneNumber();
        memberDto.licencePlateNumber = member.getLicencePlate().getNumber();
        memberDto.licencePlateCountry = member.getLicencePlate().getIssuingCountry();
        memberDto.registrationDate = member.getRegistrationDate();
        memberDto.memberShipLevel = member.getMemberShipLevel().getName();
        return memberDto;
    }

    public SimplifiedMemberDto toGetAllMembersDto(Member member) {
        SimplifiedMemberDto simplifiedMemberDto = new SimplifiedMemberDto();
        simplifiedMemberDto.id = member.getId();
        simplifiedMemberDto.firstName = member.getFirstName();
        simplifiedMemberDto.lastName = member.getLastName();
        simplifiedMemberDto.emailAdress = member.getEmailAddress().getAddress();
        simplifiedMemberDto.telephoneNumber = member.getTelephoneNumber();
        simplifiedMemberDto.licencePlateNumber = member.getLicencePlate().getNumber();
        simplifiedMemberDto.registrationDate = member.getRegistrationDate();
        return simplifiedMemberDto;
    }


}
