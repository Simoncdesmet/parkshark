package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.CreateMemberDto;
import com.dreamteam.parkshark.api.dtos.SimplifiedMemberDto;
import com.dreamteam.parkshark.api.dtos.MemberDto;
import com.dreamteam.parkshark.api.mapper.MemberDtoMapper;
import com.dreamteam.parkshark.domain.member.Member;
import com.dreamteam.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = MemberController.PATH)
public class MemberController {
    public static final String PATH = "member";
    private MemberService memberService;
    private MemberDtoMapper memberDtoMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberDtoMapper memberDtoMapper) {
        this.memberService = memberService;
        this.memberDtoMapper = memberDtoMapper;
    }

    @PostMapping(path = "/register", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto register(@RequestBody CreateMemberDto createMemberDto){
        return memberDtoMapper.toDto(memberService.register(memberDtoMapper.toMember(createMemberDto)));
    }

    @GetMapping (produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<SimplifiedMemberDto> getAll(){
        List<SimplifiedMemberDto> listDto = new ArrayList<>();
        for (Member member : memberService.getAll()){
            listDto.add(memberDtoMapper.toGetAllMembersDto(member));
        }
        return listDto;
    }
}
