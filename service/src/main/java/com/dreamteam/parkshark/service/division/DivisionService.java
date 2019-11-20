package com.dreamteam.parkshark.service.division;

import com.dreamteam.parkshark.domain.division.Division;
import com.dreamteam.parkshark.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DivisionService {
    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division createDivision(Division division) {
        return divisionRepository.save(division);
    }

    public List<Division> getAll() {
        return divisionRepository.findAll();
    }

    public Optional<Division> getById(String id) {
        try {
            return divisionRepository.findById(Long.parseLong(id));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("parent division id is not a number");
        }
    }
}
