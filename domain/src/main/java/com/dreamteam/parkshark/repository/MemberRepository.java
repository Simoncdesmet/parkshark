package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.member.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findAll();
}
