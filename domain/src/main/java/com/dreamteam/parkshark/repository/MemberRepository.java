package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.member.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findById(long memberId);
    List<Member> findAll();
}
