package com.example.securitypract.Controller;


import com.example.securitypract.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"shahzaib"),
            new Student(4,"ali"),
            new Student(10,"akram ali ")
    ));

    @GetMapping(path = "{studentId}")
    Student getStudents(@PathVariable("studentId") Integer studentId){

        return students.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("student id not exist"));
    }
}
