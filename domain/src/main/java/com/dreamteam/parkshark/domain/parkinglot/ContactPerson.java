package com.dreamteam.parkshark.domain.parkinglot;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.member.Email;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_PERSON")
public class ContactPerson {

    @Id
    @SequenceGenerator(name = "contactSeq", sequenceName = "CONTACT_PERSON_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactSeq")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MOBILE_PHONE_NUMBER")
    private String mobilePhoneNumber;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    public ContactPerson() {
    }

    public ContactPerson(String firstName, String lastName, String mobilePhoneNumber, String phoneNumber, String email, Address address) {
        checkIfAPhoneNumberIsPresent(mobilePhoneNumber, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.email = new Email(email).getAddress();
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    private void checkIfAPhoneNumberIsPresent(String mobilePhoneNumber, String phoneNumber) {
        if (mobilePhoneNumber == null && phoneNumber == null)
            throw new IllegalArgumentException("Please provide at least one phone number.");
    }


    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
