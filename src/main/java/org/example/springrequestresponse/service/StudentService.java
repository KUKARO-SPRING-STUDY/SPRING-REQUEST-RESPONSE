package org.example.springrequestresponse.service;

import lombok.RequiredArgsConstructor;
import org.example.springrequestresponse.entity.StudentEntity;
import org.example.springrequestresponse.exception.CustomException;
import org.example.springrequestresponse.repository.StudentRepository;
import org.example.springrequestresponse.response.ErrorCode;
import org.example.springrequestresponse.response.InputRestriction;
import org.example.springrequestresponse.response.Student;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(String name, String grade) {
        if (grade.compareTo("6") >= 0) {
            throw new CustomException(ErrorCode.SERVER_ERROR, "grade 는 6 이상을 입력 할 수 없습니다.", new InputRestriction("6"));
        }
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

    public void deleteAll(){
        studentRepository.deleteAll();
    }
}
