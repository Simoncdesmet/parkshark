package com.dreamteam.parkshark.api.controllers;

import com.dreamteam.parkshark.api.dtos.CreateMemberDto;
import com.dreamteam.parkshark.api.dtos.MemberDto;
import com.dreamteam.parkshark.api.mapper.Mapper;
import com.dreamteam.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = MemberController.PATH)
public class MemberController {
    public static final String PATH = "member";
    private MemberService memberService;
    private Mapper mapper;

    @Autowired
    public MemberController(MemberService memberService, Mapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping(path = "/register", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto register(@RequestBody CreateMemberDto createMemberDto){
        return mapper.toDto(memberService.register(mapper.toMember(createMemberDto)));
    }

}
