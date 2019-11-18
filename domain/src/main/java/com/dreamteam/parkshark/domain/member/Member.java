package com.dreamteam.parkshark.domain.member;

import com.dreamteam.parkshark.domain.Address;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Member {
    private static final String MEMBER_SEQ = "MEMBER_SEQ";
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = MEMBER_SEQ)
    @SequenceGenerator(name = MEMBER_SEQ, allocationSize = 1, sequenceName = MEMBER_SEQ)
    private long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String telephoneNumber;
    @Embedded
    private Email emailAdress;
    @Embedded
    private LicencePlate licencePlate;
    private LocalDate registrationDate;

    public Member() {
    }

    private Member(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
        telephoneNumber = builder.telephoneNumber;
        emailAdress = builder.emailAdress;
        licencePlate = builder.licencePlate;
        registrationDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Email getEmailAdress() {
        return emailAdress;
    }

    public LicencePlate getLicencePlate() {
        return licencePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(firstName, member.firstName) &&
                Objects.equals(lastName, member.lastName) &&
                Objects.equals(address, member.address) &&
                Objects.equals(telephoneNumber, member.telephoneNumber) &&
                Objects.equals(emailAdress, member.emailAdress) &&
                Objects.equals(licencePlate, member.licencePlate) &&
                Objects.equals(registrationDate, member.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, telephoneNumber, emailAdress, licencePlate, registrationDate);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String firstName;
        private String lastName;
        private Address address;
        private String telephoneNumber;
        private Email emailAdress;
        private LicencePlate licencePlate;

        private Builder() {
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withAddress(Address val) {
            address = val;
            return this;
        }

        public Builder withTelephoneNumber(String val) {
            telephoneNumber = val;
            return this;
        }

        public Builder withEmailAdress(Email val) {
            emailAdress = val;
            return this;
        }

        public Builder withLicencePlate(LicencePlate val) {
            licencePlate = val;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}
