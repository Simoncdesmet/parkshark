package com.dreamteam.parkshark.service.allocation;

import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.repository.ParkingSpotAllocationRepository;
import com.dreamteam.parkshark.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParkingSpotAllocationService {

    private final ParkingSpotAllocationRepository allocationRepository;
    private final MemberValidator memberValidator;
    private final ParkingLotValidator parkingLotValidator;

    public ParkingSpotAllocationService(ParkingSpotAllocationRepository allocationRepository, MemberService memberService, MemberValidator memberValidator, ParkingLotValidator parkingLotValidator) {
        this.allocationRepository = allocationRepository;
        this.memberValidator = memberValidator;
        this.parkingLotValidator = parkingLotValidator;
    }


    public ParkingSpotAllocation startParkingAllocation(ParkingSpotAllocation allocation) {
        validateAllocation(allocation);
        return allocationRepository.save(allocation);
    }

    public ParkingSpotAllocation stopParkingAllocation(String allocationExternalId, long memberId) {
        ParkingSpotAllocation allocation = allocationRepository.findByExternalId(allocationExternalId)
                .orElseThrow(() -> new IllegalArgumentException("There is no allocation with this ID!"));
        memberValidator.isAllocationOfMember(allocation, memberId);
        allocation.stopAllocation();
        return allocation;
    }

    private void validateAllocation(ParkingSpotAllocation allocation) {
        memberValidator.validateMember(allocation);
        parkingLotValidator.validateParkingLot(allocation);
    }


}
