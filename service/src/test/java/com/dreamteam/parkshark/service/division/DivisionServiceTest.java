package com.dreamteam.parkshark.service.division;

import com.dreamteam.parkshark.domain.division.Division;
import com.dreamteam.parkshark.repository.DivisionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DivisionServiceTest {
    private static final Division DIVISION = new Division("name", "original_name", "director name");
    private DivisionService divisionService;

    @BeforeEach
    void setUp(){
        DivisionRepository repository = mock(DivisionRepository.class);
        when(repository.save(DIVISION))
                .thenReturn(DIVISION);
        when(repository.findAll())
                .thenReturn(List.of(DIVISION));
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
        var retrievedDivision = divisionService.getAll().get(0);
        assertEquals(DIVISION, retrievedDivision);
    }
}
