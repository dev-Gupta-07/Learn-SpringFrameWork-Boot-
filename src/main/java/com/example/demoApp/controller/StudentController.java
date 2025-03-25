package com.example.demoApp.controller;


import com.example.demoApp.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(new Student(1,"df",23),new Student(2,"df",24),new Student(3,"dfd",25)));
    @GetMapping("/students")
    public List<Student>getStudents(){


         return students;
    }

    // now if you want  a post request it says unauthorized
    // due to crf token is not there

    // either in postman
    //headers key add X-CRF-TOKEN
    //value at logout see sorce page
    // or return token from here

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
     return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
