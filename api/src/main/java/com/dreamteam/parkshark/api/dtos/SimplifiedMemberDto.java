package com.dreamteam.parkshark.api.dtos;


import java.time.LocalDate;
import java.util.Objects;

public class SimplifiedMemberDto {
    public long id;
    public String lastName;
    public String firstName;
    public String telephoneNumber;
    public String emailAdress;
    public String licencePlateNumber;
    public LocalDate registrationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimplifiedMemberDto)) return false;
        SimplifiedMemberDto that = (SimplifiedMemberDto) o;
        return id == that.id &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(telephoneNumber, that.telephoneNumber) &&
                Objects.equals(emailAdress, that.emailAdress) &&
                Objects.equals(licencePlateNumber, that.licencePlateNumber) &&
                Objects.equals(registrationDate, that.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, telephoneNumber, emailAdress, licencePlateNumber, registrationDate);
    }

    @Override
    public String toString() {
        return "GetAllMembersDto{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", licencePlateNumber='" + licencePlateNumber + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
