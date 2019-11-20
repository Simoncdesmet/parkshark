package com.dreamteam.parkshark.repository;

import com.dreamteam.parkshark.domain.division.Division;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DivisionRepository extends CrudRepository<Division, Long> {

    List<Division> findAll();
}
