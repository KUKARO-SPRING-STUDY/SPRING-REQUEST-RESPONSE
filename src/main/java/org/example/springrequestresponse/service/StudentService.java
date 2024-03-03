package org.example.springrequestresponse.service;

import lombok.RequiredArgsConstructor;
import org.example.springrequestresponse.entity.StudentEntity;
import org.example.springrequestresponse.repository.StudentRepository;
import org.example.springrequestresponse.response.Student;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(String name, String grade) {
        StudentEntity studentEntity = studentRepository.save(new StudentEntity(null, name, grade));
        return new Student(studentEntity.name(), studentEntity.grade());
    }

    public List<Student> getAll() {
        return studentRepository.getAll().stream()
                .map(studentEntity -> new Student(studentEntity.name(), studentEntity.grade()))
//                .sorted((o1, o2) -> o1.grade().compareTo(o2.grade()))
                .sorted(Comparator.comparing(Student::grade))
                .toList();
    }

    public List<Student> getByGrade(String grade) {
        return studentRepository.getAll().stream()
                .filter(studentEntity -> grade.equals(studentEntity.grade()))
                .map(studentEntity -> new Student(studentEntity.name(), studentEntity.grade()))
                .toList();
    }
}
