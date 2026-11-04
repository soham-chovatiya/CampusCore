package com.project.CRUDSpringBootProject.Controller;


// get http request through the post-man

import com.project.CRUDSpringBootProject.Entity.Student;
import com.project.CRUDSpringBootProject.Service.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // get rest api in the form of incoming request and provide output in the form of json or any formate
@RequestMapping("/api/students") //
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // 1. Create Student

    @PostMapping("/create")

    public String createStudent(@RequestBody Student student){ //@RequestBody converts JSON data received from the client (Postman, Android app, frontend, etc.) into a Java object.
        System.out.println("Inside Student-Controller");
        Student createStudent = studentService.createdStudent(student);
        System.out.println("Exit Student-Controller");
        return " Table Created ";
    }

    // 2. Read Student data


    // 3. UPDATE Student Data


    // 4. Delete Student Data

}
