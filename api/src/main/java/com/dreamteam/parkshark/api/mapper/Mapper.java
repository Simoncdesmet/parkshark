package com.dreamteam.parkshark.api.mapper;

import com.dreamteam.parkshark.api.dtos.CreateMemberDto;
import com.dreamteam.parkshark.api.dtos.MemberDto;
import com.dreamteam.parkshark.domain.member.Member;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Member toMember(CreateMemberDto memberDto){
        return Member.newBuilder()
                .withFirstName(memberDto.firstName)
                .withLastName(memberDto.lastName)
                .withEmailAdress(memberDto.emailAdress)
                .withTelephoneNumber(memberDto.telephoneNumber)
                .withAddress(memberDto.address)
                .withLicencePlate(memberDto.licencePlate)
                .build();
    }

    public MemberDto toDto(Member member){
        MemberDto memberDto = new MemberDto();
        memberDto.id = member.getId();
        memberDto.firstName = member.getFirstName();
        memberDto.lastName = member.getLastName();
        memberDto.address = member.getAddress();
        memberDto.emailAdress = member.getEmailAdress();
        memberDto.telephoneNumber = member.getTelephoneNumber();
        memberDto.licencePlate = member.getLicencePlate();
        memberDto.registrationDate = member.getRegistrationDate();
        return memberDto;
    }
}
