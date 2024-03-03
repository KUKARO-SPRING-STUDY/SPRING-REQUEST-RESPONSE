package org.example.springrequestresponse.entity;

import java.util.Objects;

public record StudentEntity(
        Integer id,
        String name,
        String grade
) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
