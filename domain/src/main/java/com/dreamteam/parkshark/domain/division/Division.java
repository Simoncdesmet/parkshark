package com.dreamteam.parkshark.domain.division;

import javax.persistence.*;
import java.util.Objects;

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

    private Division(){}

    public Division(String name, String originalName, String directorName) {
        this.name = name;
        this.originalName = originalName;
        this.directorName = directorName;
    }

    public Division(long id, String name, String originalName, String directorName) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.directorName = directorName;
    }

    public long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return id == division.id &&
                Objects.equals(name, division.name) &&
                Objects.equals(originalName, division.originalName) &&
                Objects.equals(directorName, division.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, originalName, directorName);
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }
}
