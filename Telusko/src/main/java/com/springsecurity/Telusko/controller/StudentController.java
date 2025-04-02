package com.springsecurity.Telusko.controller;

import com.springsecurity.Telusko.model.Student;
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

    @GetMapping("/hi")
    public String sayHi(HttpServletRequest request) {
        return "Hi " + request.getSession().getId();
    }

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Navin", 60),
            new Student(2, "Prithvi", 70)
    ));

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}