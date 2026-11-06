package com.project.CRUDSpringBootProject.Repository;

import com.project.CRUDSpringBootProject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// to interact student details with database in tabular form

// @Repository  no need to declare
public interface StudentRepository extends JpaRepository<Student, Long> {

}

