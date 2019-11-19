package api.parkinglot;

import com.dreamteam.parkshark.domain.parkinglot.Address;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotDtoMapper {

    public ParkingLot toParkingLot(ParkingLotDto parkingLotDto) {
        return new ParkingLot(
                parkingLotDto.getName(),
                Category.valueOf(parkingLotDto.getCategory()),
                parkingLotDto.getMaxCapacity(),
                toContactPerson(parkingLotDto.getContactPersonDto()),
                toAddress(parkingLotDto.getAddressDto()),
                parkingLotDto.getPricePerHour());
    }

    public ParkingLotDto toParkingLotDto(ParkingLot parkingLot) {
        return new ParkingLotDto()
                .withName(parkingLot.getName())
                .withCategory(parkingLot.getCategory().toString())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withContactPersonDto(toContactPersonDto(parkingLot.getContactPerson()))
                .withAddressDto(toAddressDto(parkingLot.getAddress()))
                .withPricePerHour(parkingLot.getPricePerHour());
    }

    private ContactPersonDto toContactPersonDto(ContactPerson contactPerson) {
        return new ContactPersonDto()
                .withFirstName(contactPerson.getFirstName())
                .withLastName(contactPerson.getLastName())
                .withEmail(contactPerson.getEmail())
                .withMobilePhoneNumber(contactPerson.getMobilePhoneNumber())
                .withPhoneNumber(contactPerson.getPhoneNumber())
                .withAddress(toAddressDto(contactPerson.getAddress()));
    }

    private AddressDto toAddressDto(Address address) {
        return new AddressDto()
                .withCity(address.getCity())
                .withPostalCode(address.getPostalCode())
                .withStreetName(address.getStreetName())
                .withStreetNumber(address.getStreetNumber());
    }

    private ContactPerson toContactPerson(ContactPersonDto contactPersonDto) {
        return new ContactPerson(
                contactPersonDto.getFirstName(),
                contactPersonDto.getLastName(),
                contactPersonDto.getMobilePhoneNumber(),
                contactPersonDto.getPhoneNumber(),
                contactPersonDto.getEmail(),
                toAddress(contactPersonDto.getAddress()));
    }

    private Address toAddress(AddressDto addressDto) {
        return new Address(
                addressDto.getStreetName(),
                addressDto.getStreetNumber(),
                addressDto.getPostalCode(),
                addressDto.getCity());
    }
}
