package com.dreamteam.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public enum MembershipLevel {
    Bronze("Bronze", 0.0, 0.0, 4.0),
    Silver("Silver", 10.0, 0.2, 6.0),
    Gold("Gold", 40.0, 0.3, 24.0);

    private String name;
    private double monthlyCost;
    private double allocationReduction;
    private double maxAllocationHours;


    MembershipLevel(String name, double monthlyCost, double allocationReduction, double maxAllocationHours) {
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.allocationReduction = allocationReduction;
        this.maxAllocationHours = maxAllocationHours;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getAllocationReduction() {
        return allocationReduction;
    }

    public double getMaxAllocationHours() {
        return maxAllocationHours;
    }
}
