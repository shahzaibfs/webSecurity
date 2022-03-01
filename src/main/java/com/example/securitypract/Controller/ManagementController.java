package com.example.securitypract.Controller;


import com.example.securitypract.Entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "management/api/v1/student")
public class ManagementController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"shahzaib"),
            new Student(4,"ali"),
            new Student(10,"akram ali ")
    ));

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return students;
    }

    @PostMapping("/")
    public String  addStudent(@RequestBody Student s){
        students.add(s);

        return "Record added succesfully "  ;
    }

}
