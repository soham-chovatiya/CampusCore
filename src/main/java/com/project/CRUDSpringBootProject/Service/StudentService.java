package com.project.CRUDSpringBootProject.Service;

import com.project.CRUDSpringBootProject.Entity.Student;
import com.project.CRUDSpringBootProject.Repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// 1. End point listen (/app/students/ POST)

// 2. Business logic ( prepare for key value pair(jso) convert it into database store value)

// 3. interact with db to store

// 4. Response back to client.

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createdStudent(Student studentReq){
        System.out.println("Inside Student-Service");
        Student studentResp = studentRepository.saveStudent(studentReq);
        System.out.println("Exiting Student-Service");
        return studentResp;
    }


}
