package com.dreamteam.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LicencePlate {
    @Column
    private String number;
    private String country;

    public LicencePlate() {}

    public LicencePlate(String number, String country) {
        this.number = number;
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }
}
