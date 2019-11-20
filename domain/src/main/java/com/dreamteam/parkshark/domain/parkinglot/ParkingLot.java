package com.dreamteam.parkshark.domain.parkinglot;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.division.Division;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {


    @Id
    @SequenceGenerator(name = "PARKING_LOT_SEQ", sequenceName = "PARKING_LOT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARKING_LOT_SEQ")
    private long id;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "MAX_CAPACITY")
    private int maxCapacity;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "CONTACT_PERSON_ID")
    private ContactPerson contactPerson;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(name = "PRICE_PER_HOUR")
    private long pricePerHour;

    @OneToOne
    @JoinColumn(name = "FK_DIVISION_ID")
    private Division division;

    public ParkingLot() {
    }

    public ParkingLot(String name, Category category, int maxCapacity, ContactPerson contactPerson, Address address, long pricePerHour, Division division) {
        this.externalId = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.maxCapacity = maxCapacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public long getPricePerHour() {
        return pricePerHour;
    }

    public String getExternalId() {
        return externalId;
    }

    public Division getDivision() {
        return division;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", externalId='" + externalId + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", maxCapacity=" + maxCapacity +
                ", contactPerson=" + contactPerson +
                ", address=" + address +
                ", pricePerHour=" + pricePerHour +
                ", division=" + division +
                '}';
    }
}
