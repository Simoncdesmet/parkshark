package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.member.Email;
import com.dreamteam.parkshark.domain.member.LicencePlate;
import com.dreamteam.parkshark.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
class MemberRepositoryTest {
    private static final Address ADDRESS = Address.newBuilder()
            .withCity("city")
            .withPostalCode("postalCode")
            .withStreetName("streetName")
            .withStreetNumber("streetNumber")
            .build();
    private static final Member MEMBER = Member.newBuilder()
            .withFirstName("firstName")
            .withLastName("lastName")
            .withTelephoneNumber("phoneNumber")
            .withAddress(ADDRESS)
            .withEmailAdress(new Email("email@valid.be"))
            .withLicencePlate(new LicencePlate("ABC-123", "Belgium"))
            .build();

    @Autowired
    private MemberRepository repository;

    @Test
    @DisplayName("a member object remains the same after persisting")
    void basicFunctionality1() {
        var persistedMember = repository.save(MEMBER);
        assertEquals(MEMBER, persistedMember);
    }

    @Test
    @DisplayName("a member object remains the same after persisting and retrieving")
    void basicFunctionality2() {
        var persistedMember = repository.save(MEMBER);
        var retrievedMember = repository.findById(persistedMember.getId());
        assertEquals(MEMBER, retrievedMember.orElseThrow());
    }

    @Test
    @DisplayName("getting all the members returns a list where the first element is the persisted one")
    void getAllMembers(){
        repository.save(MEMBER);
        var retrievedMember = repository.findAll().get(0);
        assertEquals(MEMBER, retrievedMember);
    }
}
