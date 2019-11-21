package com.dreamteam.parkshark.api.dtos;

import com.dreamteam.parkshark.domain.member.LicencePlate;

import java.time.LocalDate;
import java.util.Objects;

public class MemberDto {
    public long id;
    public String lastName;
    public String firstName;
    public AddressDto address;
    public String telephoneNumber;
    public String emailAddress;
    public String licencePlateNumber;
    public String licencePlateCountry;
    public LocalDate registrationDate;
    public String memberShipLevel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return id == memberDto.id &&
                Objects.equals(lastName, memberDto.lastName) &&
                Objects.equals(firstName, memberDto.firstName) &&
                Objects.equals(address, memberDto.address) &&
                Objects.equals(telephoneNumber, memberDto.telephoneNumber) &&
                Objects.equals(emailAddress, memberDto.emailAddress) &&
                Objects.equals(licencePlateNumber, memberDto.licencePlateNumber) &&
                Objects.equals(licencePlateCountry, memberDto.licencePlateCountry) &&
                Objects.equals(registrationDate, memberDto.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, address, telephoneNumber, emailAddress, licencePlateNumber, licencePlateCountry, registrationDate);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address=" + address +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", licencePlateNumber='" + licencePlateNumber + '\'' +
                ", licencePlateCountry='" + licencePlateCountry + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
