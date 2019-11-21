package com.dreamteam.parkshark.service.member;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.member.Email;
import com.dreamteam.parkshark.domain.member.LicencePlate;
import com.dreamteam.parkshark.domain.member.Member;
import com.dreamteam.parkshark.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class MemberServiceUnitTest {
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
            .withEmailAddress(new Email("email@valid.be"))
            .withLicencePlate(new LicencePlate("ABC-123", "Belgium"))
            .build();

    private MemberService service;

    @BeforeEach
    void setUp() {
        MemberRepository repository = mock(MemberRepository.class);
        when(repository.save(MEMBER))
                .thenReturn(MEMBER);
        when(repository.findAll())
                .thenReturn((List.of(MEMBER)));
        when(repository.findById(MEMBER.getId()))
                .thenReturn(Optional.of(MEMBER));
        service = new MemberService(repository);
    }

    @Test
    @DisplayName("when registering a member, the registered member is returned by the service")
    void basicFunctionality() {
        var persistedMember = service.register(MEMBER);
        assertEquals(MEMBER, persistedMember);
    }

    @Test
    @DisplayName("getting all the members returns a list including the expected member")
    void getAllMembers(){
        var retrievedMember = service.getAll().get(0);
        assertEquals(MEMBER, retrievedMember);
    }

    @Test
    @DisplayName("getting a member by id returns an optional with the expected member")
    void getAMembers(){
        var retrievedMember = service.getById(MEMBER.getId()).orElseThrow();
        assertEquals(MEMBER, retrievedMember);
    }

}