package com.dreamteam.parkshark.domain.member;

import com.dreamteam.parkshark.domain.Address;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static com.dreamteam.parkshark.domain.member.MembershipLevel.*;
import static java.util.Objects.requireNonNull;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    private String telephoneNumber;

    @Column(name = "MEMBERSHIP_LEVEL")
    @Enumerated(EnumType.STRING)
    private MembershipLevel memberShipLevel = Bronze;

    @Embedded
    @AttributeOverride(name = "address", column = @Column(name = "EMAIL_ADDRESS"))
    private Email emailAddress;

    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "LICENCE_PLATE_NUMBER"))
    @AttributeOverride(name = "issuingCountry", column = @Column(name = "LICENCE_PLATE_COUNTRY"))
    private LicencePlate licencePlate;
    private LocalDate registrationDate;

    public Member() {
    }

    private Member(Builder builder) {
        firstName = requireNonNull(builder.firstName, "first name required");
        lastName = requireNonNull(builder.lastName, "last name required");
        address = requireNonNull(builder.address, "address required");
        telephoneNumber = requireNonNull(builder.telephoneNumber, "telephone number required");
        emailAddress = requireNonNull(builder.emailAddress, "email address required");
        licencePlate = requireNonNull(builder.licencePlate, "licence plate required");
        registrationDate = LocalDate.now();
        if (builder.membershipLevel != null) memberShipLevel = builder.membershipLevel;
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

    public Email getEmailAddress() {
        return emailAddress;
    }

    public LicencePlate getLicencePlate() {
        return licencePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public MembershipLevel getMemberShipLevel() {
        return memberShipLevel;
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
                Objects.equals(emailAddress, member.emailAddress) &&
                Objects.equals(licencePlate, member.licencePlate) &&
                Objects.equals(registrationDate, member.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, telephoneNumber, emailAddress, licencePlate, registrationDate);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", emailAddress=" + emailAddress +
                ", licencePlate=" + licencePlate +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String firstName;
        private String lastName;
        private Address address;
        private String telephoneNumber;
        private Email emailAddress;
        private LicencePlate licencePlate;
        private MembershipLevel membershipLevel;

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

        public Builder withEmailAddress(Email val) {
            emailAddress = val;
            return this;
        }

        public Builder withEmailAddress(String val) {
            emailAddress = new Email(val);
            return this;
        }

        public Builder withLicencePlate(LicencePlate val) {
            licencePlate = val;
            return this;
        }

        public Builder withMemberShipLevel(MembershipLevel val) {
            membershipLevel = val;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}
