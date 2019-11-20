package com.dreamteam.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
public class Email {
    private static final Pattern PATTERN = Pattern.compile("^.+@.+\\..+$");
    @Column (name = "EMAIL_ADDRESS")
    private String address;

    public Email() {
    }

    public Email(String address) {
        this.address = validate(address);
    }

    private String validate(String address) {
        if (! PATTERN.matcher(address).matches())
            throw new IllegalArgumentException("invalid email format");
        return address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return address.equals(email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                '}';
    }
}
