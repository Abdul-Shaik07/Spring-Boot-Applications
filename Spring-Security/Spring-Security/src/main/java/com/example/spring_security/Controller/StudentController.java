package com.example.spring_security.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security.Entity.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    //List<Student> studentDetails;

    List<Student> studentList = new ArrayList<>(List.of(
        new Student(1, "Abdul"),
        new Student(2, "Tom")
    ));

    @GetMapping("/home-page")
    public String home(HttpServletRequest httpServletRequest){
        return "Home page" + " " + httpServletRequest.getSession().getId();
    }

    @GetMapping("/students")
    public List<Student> listOfStudents(){
        return studentList;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest) {
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public Student getStudent(@RequestBody Student student) {
        studentList.add(student);
        return student;
    }
}
