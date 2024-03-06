package org.example.springrequestresponse.controller;

import lombok.RequiredArgsConstructor;
import org.example.springrequestresponse.exception.CustomException;
import org.example.springrequestresponse.response.ApiResponse;
import org.example.springrequestresponse.response.ErrorCode;
import org.example.springrequestresponse.response.InputRestriction;
import org.example.springrequestresponse.response.Student;
import org.example.springrequestresponse.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.springrequestresponse.response.ApiResponse.makeResponse;

@Controller
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("")
    public ApiResponse<Student> searchAllStudent() {
        List<Student> result = studentService.getAll();
        return makeResponse(result);
    }

    @GetMapping("/grade/{grade}")
    public ApiResponse<Student> searchStudentByGrade(@PathVariable String grade) {
        List<Student> result = studentService.getByGrade(grade);
        return makeResponse(result);
    }

    @PostMapping("")
    public ApiResponse<Student> saveStudent(@RequestBody Student student) {
        Student result = studentService.save(student.name(), student.grade());
        return makeResponse(result);
    }

    @DeleteMapping("")
    public ApiResponse<Student> deleteAllStudent() {
        studentService.deleteAll();
        return makeResponse(List.of());
    }
}
