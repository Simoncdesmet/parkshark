package com.dreamteam.parkshark.api.mapper;

import com.dreamteam.parkshark.api.dtos.*;
import com.dreamteam.parkshark.domain.parkinglot.Category;
import com.dreamteam.parkshark.domain.parkinglot.ContactPerson;
import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingLotDtoMapper {

    private final AddressDtoMapper addressDtoMapper;

    public ParkingLotDtoMapper(AddressDtoMapper addressDtoMapper) {
        this.addressDtoMapper = addressDtoMapper;
    }

    public ParkingLot toParkingLot(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot(
                createParkingLotDto.getName(),
                Category.valueOf(createParkingLotDto.getCategory()),
                createParkingLotDto.getMaxCapacity(),
                toContactPerson(createParkingLotDto.getContactPersonDto()),
                addressDtoMapper.toAddress(createParkingLotDto.getAddressDto()),
                createParkingLotDto.getPricePerHour(),
                createParkingLotDto.getDivisionId());
    }

    public CreateParkingLotDto toCreateParkingLotDto(ParkingLot parkingLot) {
        return new CreateParkingLotDto()
                .withName(parkingLot.getName())
                .withCategory(parkingLot.getCategory().toString())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withContactPersonDto(toContactPersonDto(parkingLot.getContactPerson()))
                .withAddressDto(addressDtoMapper.toAddressDto(parkingLot.getAddress()))
                .withPricePerHour(parkingLot.getPricePerHour())
                .withDivision(parkingLot.getDivisionId());
    }

    public SingleParkingLotDto toSingleParkingLotDto(ParkingLot parkingLot) {
        return new SingleParkingLotDto()
                .withExternalId(parkingLot.getExternalId())
                .withName(parkingLot.getName())
                .withCategory(parkingLot.getCategory().toString())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withContactPersonDto(toContactPersonDto(parkingLot.getContactPerson()))
                .withAddressDto(addressDtoMapper.toAddressDto(parkingLot.getAddress()))
                .withPricePerHour(parkingLot.getPricePerHour());
    }

    public ParkingLotDto toParkingLotDto(ParkingLot parkingLot){
        return new ParkingLotDto()
                .withExternalId(parkingLot.getExternalId())
                .withName(parkingLot.getName())
                .withMaxCapacity(parkingLot.getMaxCapacity())
                .withContactPersonDto(toSimplifiedContactDto(parkingLot.getContactPerson()));
    }

    private ContactPersonDto toContactPersonDto(ContactPerson contactPerson) {
        return new ContactPersonDto()
                .withFirstName(contactPerson.getFirstName())
                .withLastName(contactPerson.getLastName())
                .withEmail(contactPerson.getEmail())
                .withMobilePhoneNumber(contactPerson.getMobilePhoneNumber())
                .withPhoneNumber(contactPerson.getPhoneNumber())
                .withAddress(addressDtoMapper.toAddressDto(contactPerson.getAddress()));
    }

    private SimplifiedContactDto toSimplifiedContactDto(ContactPerson contactPerson){
        return new SimplifiedContactDto()
                .withEmail(contactPerson.getEmail())
                .withMobilePhoneNumber(contactPerson.getMobilePhoneNumber())
                .withPhoneNumber(contactPerson.getPhoneNumber());
    }



    private ContactPerson toContactPerson(ContactPersonDto contactPersonDto) {
        return new ContactPerson(
                contactPersonDto.getFirstName(),
                contactPersonDto.getLastName(),
                contactPersonDto.getMobilePhoneNumber(),
                contactPersonDto.getPhoneNumber(),
                contactPersonDto.getEmail(),
                addressDtoMapper.toAddress(contactPersonDto.getAddress()));
    }


    public List<ParkingLotDto> toParkingLotDtos(List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .map(this::toParkingLotDto)
                .collect(Collectors.toList());
    }
}
