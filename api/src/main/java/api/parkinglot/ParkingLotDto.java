package api.parkinglot;

import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;

public class ParkingLotDto {

    private String name;
    private int maxCapacity;
    private int pricePerHour;
    private ContactPersonDto contactPersonDto;
    private AddressDto addressDto;
    private String category;

    public ParkingLotDto withName(String name) {
        this.name = name;
        return this;
    }

    public ParkingLotDto withMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public ParkingLotDto withPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    public ParkingLotDto withContactPersonDto(ContactPersonDto contactPersonDto) {
        this.contactPersonDto = contactPersonDto;
        return this;
    }

    public ParkingLotDto withAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public ParkingLotDto withCategory(String category) {
        this.category = category;
        return this;
    }
}
