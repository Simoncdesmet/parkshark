package com.dreamteam.parkshark.service.allocation;

import com.dreamteam.parkshark.domain.allocation.ParkingSpotAllocation;
import com.dreamteam.parkshark.domain.allocation.Status;
import com.dreamteam.parkshark.repository.ParkingSpotAllocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParkingSpotAllocationService {

    private final ParkingSpotAllocationRepository allocationRepository;
    private final MemberValidator memberValidator;
    private final ParkingLotValidator parkingLotValidator;

    public ParkingSpotAllocationService(ParkingSpotAllocationRepository allocationRepository, MemberValidator memberValidator, ParkingLotValidator parkingLotValidator) {
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

    public List<ParkingSpotAllocation> getAllAllocations(String number, String order, String status) {
        var allSpots = allocationRepository.findAll();
        Collections.sort(allSpots);
        if (number != null){
            allSpots = getNumberOfAllocationsGivenByParam(allSpots, number);
        }
        if (status != null){
            allSpots = getAllocationsFilteredByStatus(allSpots, status);
        }
        if (order != null){
            allocationsSortedByParam(allSpots, order);
        }
        return allSpots;
    }

    private List<ParkingSpotAllocation> getNumberOfAllocationsGivenByParam(List<ParkingSpotAllocation> allocations, String number){
        int finalNumber = 0;
        try {
            finalNumber = Integer.parseInt(number);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if (finalNumber > 0){
            return allocations.stream().limit(finalNumber).collect(Collectors.toList());
        }
        else {
            return allocations;
        }
    }

    private void allocationsSortedByParam(List<ParkingSpotAllocation> allocations, String order){
        if (order.toLowerCase().equals("desc")){
            Collections.reverse(allocations);
        }
        else if (order.toLowerCase().equals("asc")){
            Collections.sort(allocations);
        }
    }

    private List<ParkingSpotAllocation> getAllocationsFilteredByStatus(List<ParkingSpotAllocation> allocations, String status){
        if (status.toLowerCase().equals("stopped") || status.toLowerCase().equals("active")){
            return allocations.stream().filter(a -> a.getStatus().equals(Status.valueOf(status.toUpperCase()))).collect(Collectors.toList());
        }
        return allocations;
    }
}
