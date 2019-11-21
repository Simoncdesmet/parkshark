package com.dreamteam.parkshark.service.division;

import com.dreamteam.parkshark.domain.division.Division;
import com.dreamteam.parkshark.repository.DivisionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DivisionServiceUnitTest {
    private static final Division DIVISION = new Division("name", "original_name", "director name");
    private DivisionService divisionService;

    @BeforeEach
    void setUp(){
        DivisionRepository repository = mock(DivisionRepository.class);
        when(repository.save(DIVISION))
                .thenReturn(DIVISION);
        when(repository.findAll())
                .thenReturn(List.of(DIVISION));
        when(repository.findById(DIVISION.getId()))
                .thenReturn(Optional.of(DIVISION));
        divisionService = new DivisionService(repository);
    }

    @Test
    @DisplayName("when creating a division, the created division is returned by the service")
    void basicFunctionality(){
        var persistedDivision = divisionService.createDivision(DIVISION);
        assertEquals(DIVISION, persistedDivision);
    }

    @Test
    @DisplayName("getting all the divisions returns a list including the expected division")
    void getAllDivisions(){
        var firstRetrievedDivision = divisionService.getAll().get(0);
        assertEquals(DIVISION, firstRetrievedDivision);
    }

    @Test
    @DisplayName("getting a division by id returns an optional containing the expected division")
    void getADivision(){
        assertEquals(
                DIVISION,
                divisionService.getById(DIVISION.getId())
                               .orElseThrow()
        );
    }

}
