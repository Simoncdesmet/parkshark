package com.dreamteam.parkshark.api.dtos;

import java.util.Objects;

public class SimplifiedContactDto {
    private String email;
    private String mobilePhoneNumber;
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public SimplifiedContactDto withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public SimplifiedContactDto withMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SimplifiedContactDto withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "SimplifiedContactDto{" +
                "email='" + email + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplifiedContactDto that = (SimplifiedContactDto) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(mobilePhoneNumber, that.mobilePhoneNumber) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobilePhoneNumber, phoneNumber);
    }
}
