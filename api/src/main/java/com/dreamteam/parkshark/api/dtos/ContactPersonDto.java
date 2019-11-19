package com.dreamteam.parkshark.api.dtos;

import java.util.Objects;

public class ContactPersonDto {

    private String firstName;
    private String lastName;
    private AddressDto address;
    private String email;
    private String mobilePhoneNumber;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressDto getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ContactPersonDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactPersonDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactPersonDto withAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public ContactPersonDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactPersonDto withMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public ContactPersonDto withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPersonDto that = (ContactPersonDto) o;
        return firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                address.equals(that.address) &&
                email.equals(that.email) &&
                Objects.equals(mobilePhoneNumber, that.mobilePhoneNumber) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, email, mobilePhoneNumber, phoneNumber);
    }
}
