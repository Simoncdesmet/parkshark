package com.dreamteam.parkshark.domain.division;

import javax.persistence.*;

@Entity
@Table(name = "DIVISION")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIVISION_SEQ")
    @SequenceGenerator(sequenceName = "division_seq", allocationSize = 1, name = "DIVISION_SEQ")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "director_name")
    private String directorName;

    public Division(String name, String originalName, String directorName) {
        this.name = name;
        this.originalName = originalName;
        this.directorName = directorName;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirectorName() {
        return directorName;
    }
}
