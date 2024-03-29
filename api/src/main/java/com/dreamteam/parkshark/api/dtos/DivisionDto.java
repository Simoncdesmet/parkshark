package com.dreamteam.parkshark.api.dtos;

import java.util.Objects;

public class DivisionDto {
    public long id;
    public String name;
    public String originalName;
    public String directorName;
    public String parentDivisionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DivisionDto)) return false;
        DivisionDto that = (DivisionDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(originalName, that.originalName) &&
                Objects.equals(directorName, that.directorName) &&
                Objects.equals(parentDivisionId, that.parentDivisionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, originalName, directorName, parentDivisionId);
    }

    @Override
    public String toString() {
        return "DivisionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", directorName='" + directorName + '\'' +
                ", parentDivisionId='" + parentDivisionId + '\'' +
                '}';
    }
}



