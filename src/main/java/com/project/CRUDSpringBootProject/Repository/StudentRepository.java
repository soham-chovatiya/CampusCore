package com.project.CRUDSpringBootProject.Repository;

import com.project.CRUDSpringBootProject.Entity.Student;
import org.springframework.stereotype.Component;

// to interact student details with database in tabular form

@Component
public class StudentRepository {

    public Student saveStudent(Student studentReq){
        System.out.println("Inside Student-Repository");
        System.out.println("Exit Student-Repository");
        return null;
    }

}
