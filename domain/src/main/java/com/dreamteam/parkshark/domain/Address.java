package com.dreamteam.parkshark.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    @Id
    @SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    private long id;

    private String city;
    private String postalCode;
    private String streetName;
    private String streetNumber;

    public Address() {
    }

    public Address(String city, String postalCode, String streetName, String streetNumber) {
        this.city = validate(city);
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private String validate(String city) {
        if (city == null || city.isBlank())
            throw new IllegalArgumentException("City is required!");
        return city;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(streetNumber, address.streetNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, postalCode, streetName, streetNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }


    public static final class Builder {
        private String city;
        private String postalCode;
        private String streetName;
        private String streetNumber;

        private Builder() {
        }

        public Builder withCity(String val) {
            city = val;
            return this;
        }

        public Builder withPostalCode(String val) {
            postalCode = val;
            return this;
        }

        public Builder withStreetName(String val) {
            streetName = val;
            return this;
        }

        public Builder withStreetNumber(String val) {
            streetNumber = val;
            return this;
        }

        public Address build() {
            return new Address(city, postalCode, streetName, streetNumber);
        }
    }
}
