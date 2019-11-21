package com.dreamteam.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBERSHIP_LEVEL")
public enum MembershipLevel {
    BRONZE(1),
    SILVER(2),
    GOLD(3);

    @Id
    @Column(name = "Id")
    private int levelId;

    @Column(name = "MONTHLY_COST")
    private double monthlyCost;
    @Column(name = "ALLOCATION_REDUCTION")
    private double allocationReduction;
    @Column(name = "MAX_ALLOCATION_HOURS")
    private int maxAllocationHours;

    MembershipLevel() {
    }

    MembershipLevel(int levelId) {
        this.levelId = levelId;
    }

    public int getId() {
        return levelId;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getAllocationReduction() {
        return allocationReduction;
    }

    public int getMaxAllocationHours() {
        return maxAllocationHours;
    }
}
