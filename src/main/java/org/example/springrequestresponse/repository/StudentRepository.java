package org.example.springrequestresponse.repository;

import jakarta.annotation.PostConstruct;
import org.example.springrequestresponse.entity.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentRepository {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    private final HashMap<Integer, StudentEntity> studentMap = new HashMap<>();

    @PostConstruct
    public void init() {
        studentMap.put(atomicInteger.incrementAndGet(), new StudentEntity(atomicInteger.get(), "kim", "1"));
        studentMap.put(atomicInteger.incrementAndGet(), new StudentEntity(atomicInteger.get(), "lee", "3"));
    }

    public StudentEntity save(StudentEntity studentEntity) {
        int id = atomicInteger.incrementAndGet();
        StudentEntity newStudentEntity= new StudentEntity(id, studentEntity.name(), studentEntity.grade());
        studentMap.put(id, studentEntity);
        return newStudentEntity;
    }

    public List<StudentEntity> getAll() {
        return studentMap.entrySet().stream()
                .map(entry -> new StudentEntity(entry.getKey(), entry.getValue().name(), entry.getValue().grade()))
                .toList();
    }
}
