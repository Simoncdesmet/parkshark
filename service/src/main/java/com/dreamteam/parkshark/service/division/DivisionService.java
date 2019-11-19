package com.dreamteam.parkshark.service.division;

import com.dreamteam.parkshark.domain.division.Division;
import com.dreamteam.parkshark.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        List<Division> list = new ArrayList<>();
        var result = divisionRepository.findAll();
        result.forEach(list::add);
        return list;
    }
}
