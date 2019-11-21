package com.dreamteam.parkshark.service.member;

import com.dreamteam.parkshark.domain.Address;
import com.dreamteam.parkshark.domain.member.Email;
import com.dreamteam.parkshark.domain.member.LicencePlate;
import com.dreamteam.parkshark.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static com.dreamteam.parkshark.domain.member.MembershipLevel.*;

@SpringBootTest
@AutoConfigureTestDatabase
@EntityScan(basePackages = "com.dreamteam.parkshark")
public class MemberServiceIntegrationTest {

    @Autowired
    private MemberService memberService;

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

    @Sql(scripts = "classpath:insert-parkinglot-and-member.sql")
    @Test
    void whenGettingAMemberWithLevelBronze_membershipLevelContainsRightValues() {

        Member foundMember = memberService.findMemberById(999);
        Assertions.assertEquals(foundMember.getMemberShipLevel().getMonthlyCost(), 0);
        Assertions.assertEquals(foundMember.getMemberShipLevel().getAllocationReduction(), 0.0);
        Assertions.assertEquals(foundMember.getMemberShipLevel().getMaxAllocationHours(), 4.0);
    }


    @Test
    void whenCreatingAMemberWithoutLevel_memberHasMembershipBronze() {
        Member createdMember = memberService.register(MEMBER);
        Assertions.assertEquals(createdMember.getMemberShipLevel().getMonthlyCost(), 0);
        Assertions.assertEquals(createdMember.getMemberShipLevel().getAllocationReduction(), 0.0);
        Assertions.assertEquals(createdMember.getMemberShipLevel().getMaxAllocationHours(), 4.0);
    }

    @Sql(scripts = "classpath:delete-rows.sql")
    @Test
    void whenCreatingAMemberWithLevelSilver_memberHasMembershipSilver() {
        Address address = Address.newBuilder()
                .withCity("city")
                .withPostalCode("postalCode")
                .withStreetName("streetName")
                .withStreetNumber("streetNumber")
                .build();
        Member createdMember = memberService.register(Member.newBuilder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .withTelephoneNumber("phoneNumber")
                .withAddress(address)
                .withEmailAddress(new Email("email@valid.be"))
                .withLicencePlate(new LicencePlate("ABC-123", "Belgium"))
                .withMemberShipLevel(Silver)
                .build());
        Assertions.assertEquals(createdMember.getMemberShipLevel().getMonthlyCost(), 10);
        Assertions.assertEquals(createdMember.getMemberShipLevel().getAllocationReduction(), 0.2);
        Assertions.assertEquals(createdMember.getMemberShipLevel().getMaxAllocationHours(), 6.0);
    }
}
