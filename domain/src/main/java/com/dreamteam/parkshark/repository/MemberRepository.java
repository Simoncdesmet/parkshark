package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.member.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
