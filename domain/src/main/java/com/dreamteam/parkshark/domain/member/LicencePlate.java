package com.dreamteam.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "LicencePlate{" +
                "number='" + number + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicencePlate that = (LicencePlate) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, country);
    }
}
