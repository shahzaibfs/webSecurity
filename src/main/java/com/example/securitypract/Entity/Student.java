package com.example.securitypract.Entity;

public class Student {

    private Integer id  ;
    private String studentName ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Student(Integer id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

}
