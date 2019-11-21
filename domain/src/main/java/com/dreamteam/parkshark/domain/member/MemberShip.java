package com.dreamteam.parkshark.domain.member;

import javax.persistence.*;

@Entity
@Table(name = "MEMBERSHIP")
public class MemberShip {

    @Id
    @Column(name = "id")
    private int membershipLevel;

    @Column(name = "MONTHLY_COST")
    private double monthlyCost;
    @Column(name = "ALLOCATION_REDUCTION")
    private double allocationReduction;
    @Column(name = "MAX_ALLOCATION_HOURS")
    private int maxAllocationHours;

    public MemberShip() {
    }

    public MemberShip(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel.getId();
    }
}
