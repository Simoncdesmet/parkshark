package com.dreamteam.parkshark.domain.allocation;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

import static com.dreamteam.parkshark.domain.allocation.Status.*;

@Entity
@Table(name = "PARKING_SPOT_ALLOCATION")
public class ParkingSpotAllocation implements Comparable<ParkingSpotAllocation> {

    @Id
    @SequenceGenerator(name = "ALLOCATION_SEQ", sequenceName = "ALLOCATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLOCATION_SEQ")
    private long id;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "MEMBER_ID")
    private long memberId;

    @Column(name = "LICENSE_PLATE_NUMBER")
    private String licensePlateNumber;

    @Column(name = "PARKING_LOT_ID")
    private String parkingLotId;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "STOP_TIME")
    private LocalDateTime stopTime;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;


    public ParkingSpotAllocation() {
    }

    public ParkingSpotAllocation(long memberId, String licensePlateNumber, String parkingLotId) {
        this.externalId = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.licensePlateNumber = licensePlateNumber;
        this.parkingLotId = parkingLotId;
        this.startTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.status = ACTIVE;
    }

    public String getExternalId() {
        return externalId;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Status getStatus() {
        return status;
    }

    public void stopAllocation() {
        status = STOPPED;
        this.stopTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpotAllocation that = (ParkingSpotAllocation) o;
        return memberId == that.memberId &&
                Objects.equals(licensePlateNumber, that.licensePlateNumber) &&
                Objects.equals(parkingLotId, that.parkingLotId) &&
                Objects.equals(startTime, that.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, licensePlateNumber, parkingLotId, startTime);
    }

    @Override
    public String toString() {
        return "ParkingSpotAllocation{" +
                "externalId='" + externalId + '\'' +
                ", memberId=" + memberId +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", parkingLotId='" + parkingLotId + '\'' +
                ", startTime=" + startTime +
                '}';
    }

    public LocalDateTime getStopTime() {
    return this.stopTime;
    }


    @Override
    public int compareTo(ParkingSpotAllocation o) {
        return startTime.compareTo(o.startTime);
    }
}
