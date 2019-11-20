package com.dreamteam.parkshark.service;

import com.dreamteam.parkshark.domain.member.Member;
import com.dreamteam.parkshark.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class MemberService {
    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member register(Member member) {
        return repository.save(member);
    }

    public Member findMemberById(long memberId) {
         return repository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("No member found with this id!"));
    }

}
