package com.dreamteam.parkshark.domain.parkinglot;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_PERSON")
public class ContactPerson {

    @Id
    @SequenceGenerator(name = "contactSeq", sequenceName = "CONTACT_PERSON_SEQ", initialValue = 1, allocationSize = 1)
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
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        validateInput();
    }

    private void validateInput() {
        checkIfAPhoneNumberIsPresent();
        checkIfEmailIsValid();
    }

    public void checkIfAPhoneNumberIsPresent() {
        if (mobilePhoneNumber == null && phoneNumber == null)
            throw new IllegalArgumentException("Please provide at least one phone number.");
    }

    private void checkIfEmailIsValid() throws IllegalArgumentException {
        if (!email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
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
