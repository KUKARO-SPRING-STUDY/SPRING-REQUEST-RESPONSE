package org.example.springrequestresponse.repository;

import jakarta.annotation.PostConstruct;
import org.example.springrequestresponse.entity.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    private int count = 0;
    private final HashMap<Integer, StudentEntity> studentMap = new HashMap<>();

    @PostConstruct
    public void init() {
        count++;
        studentMap.put(count, new StudentEntity(count, "kim", "1"));
        count++;
        studentMap.put(count, new StudentEntity(count, "lee", "3"));
    }

    public StudentEntity save(StudentEntity studentEntity) {
        count++;
        StudentEntity newStudentEntity = new StudentEntity(count,
                studentEntity.name(),
                studentEntity.grade());
        studentMap.put(count, studentEntity);
        return newStudentEntity;
    }

    public List<StudentEntity> getAll() {
        return studentMap.entrySet().stream()
                .map(entry -> new StudentEntity(entry.getKey(),
                        entry.getValue().name(),
                        entry.getValue().grade()))
                .toList();
    }

    public void deleteAll(){
        studentMap.clear();
    }
}
