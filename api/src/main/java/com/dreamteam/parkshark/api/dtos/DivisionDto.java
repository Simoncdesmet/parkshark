package com.dreamteam.parkshark.api.dtos;

import java.util.Objects;

public class DivisionDto {
    public long id;
    public String name;
    public String originalName;
    public String directorName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionDto that = (DivisionDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(originalName, that.originalName) &&
                Objects.equals(directorName, that.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, originalName, directorName);
    }

    @Override
    public String toString() {
        return "DivisionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }
}
