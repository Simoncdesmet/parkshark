package com.dreamteam.parkshark.api.mapper;

import com.dreamteam.parkshark.api.dtos.AddressDto;
import com.dreamteam.parkshark.domain.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoMapper {

    public AddressDto toAddressDto(Address address) {
        return new AddressDto()
                .withCity(address.getCity())
                .withPostalCode(address.getPostalCode())
                .withStreetName(address.getStreetName())
                .withStreetNumber(address.getStreetNumber());
    }

    public Address toAddress(AddressDto addressDto) {
        return new Address(
                addressDto.getCity(),
                addressDto.getPostalCode(),
                addressDto.getStreetName(),
                addressDto.getStreetNumber());
    }
}
