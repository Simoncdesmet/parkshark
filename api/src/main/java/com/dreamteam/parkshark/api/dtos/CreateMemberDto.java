package com.dreamteam.parkshark.api.dtos;

import com.dreamteam.parkshark.domain.member.LicencePlate;

import java.util.Objects;

public class CreateMemberDto {
    public String lastName;
    public String firstName;
    public AddressDto address;
    public String telephoneNumber;
    public String emailAddress;
    public String licencePlateNumber;
    public String licencePlateCountry;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateMemberDto that = (CreateMemberDto) o;
        return Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(telephoneNumber, that.telephoneNumber) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(licencePlateNumber, that.licencePlateNumber) &&
                Objects.equals(licencePlateCountry, that.licencePlateCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, address, telephoneNumber, emailAddress, licencePlateNumber, licencePlateCountry);
    }

    @Override
    public String toString() {
        return "CreateMemberDto{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address=" + address +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", emailAdress='" + emailAddress + '\'' +
                ", licencePlateNumber='" + licencePlateNumber + '\'' +
                ", licencePlateCountry='" + licencePlateCountry + '\'' +
                '}';
    }
}
