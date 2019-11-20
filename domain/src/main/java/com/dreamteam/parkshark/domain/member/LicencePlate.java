package com.dreamteam.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class LicencePlate {
    @Column(name = "LICENCE_PLATE_NUMBER")
    private String number;
    @Column(name = "LICENCE_PLATE_COUNTRY")
    private String issuingCountry;

    public LicencePlate() {}

    public LicencePlate(String number, String issuingCountry) {
        this.number = number;
        this.issuingCountry = issuingCountry;
    }

    public String getNumber() {
        return number;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    @Override
    public String toString() {
        return "LicencePlate{" +
                "number='" + number + '\'' +
                ", country='" + issuingCountry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicencePlate that = (LicencePlate) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(issuingCountry, that.issuingCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, issuingCountry);
    }
}
