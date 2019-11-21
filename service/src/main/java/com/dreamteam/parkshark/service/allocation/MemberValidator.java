package com.dreamteam.parkshark.service.allocation;

import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.domain.member.Member;
import com.dreamteam.parkshark.domain.member.MembershipLevel;
import com.dreamteam.parkshark.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberValidator {

    private final MemberService memberService;

    @Autowired
    public MemberValidator(MemberService memberService) {
        this.memberService = memberService;
    }


    public void validateMember(ParkingSpotAllocation allocation) {
        Member member = getMember(allocation);
        checkLicensePlateNumber(allocation, member);
    }

    private Member getMember(ParkingSpotAllocation allocation) {
        return memberService.findMemberById(allocation.getMemberId());
    }

    private void checkLicensePlateNumber(ParkingSpotAllocation allocation, Member member) {
        if (member.getMemberShipLevel() != MembershipLevel.Gold &&
                !member.getLicencePlate().getNumber().equals(allocation.getLicensePlateNumber())) {
            throw new IllegalArgumentException("Licence plate number does not match member!");
        }
    }

    public void isAllocationOfMember(ParkingSpotAllocation allocation, long memberId) {
        if (memberId != allocation.getMemberId()) {
            throw new IllegalArgumentException("You are not authorized to stop this allocation!");
        }
    }
}
