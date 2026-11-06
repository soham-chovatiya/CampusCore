package com.project.CRUDSpringBootProject.Controller;


// get http request through the post-man

import com.project.CRUDSpringBootProject.Entity.Student;
import com.project.CRUDSpringBootProject.Service.StudentService;
import org.apache.coyote.Response;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController  // get rest api in the form of incoming request and provide output in the form of json or any formate
@RequestMapping("/api/students") //
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // 1. Create Student

    @PostMapping("/create")

    public ResponseEntity<Student> createStudent(@RequestBody Student student){ //@RequestBody converts JSON data received from the client (Postman, Android app, frontend, etc.) into a Java object.

        Student createStudent = studentService.createdStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent);
    }

    // 2. Read Student data

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){  // @PathVariable extracts values from the URL and store them in controller method parameters.
        Student studentGet = studentService.getStudent(id);

        if(studentGet == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentGet);
    }

    @GetMapping("/getAll")
    public ResponseEntity <List<Student>> getAllStudent(){  // @PathVariable extracts values from the URL and store them in controller method parameters.

        List<Student> studentList = studentService.getAllStudent();

        if(studentList == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }


    // 3. UPDATE Student Data

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent (@PathVariable Long id,
                                                  @RequestBody Student studentReqBody){  // @PathVariable extracts values from the URL and store them in controller method parameters.
        Student updateStudent = studentService.updateStudent(id, studentReqBody);

        if(updateStudent == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateStudent);
    }

    @PutMapping("/updateAll")
    public ResponseEntity<List<Student>> updateAllStudent (@RequestBody List<Student> updateAllStudentsList){  // @PathVariable extracts values from the URL and store them in controller method parameters.
        List<Student> updateStudents = studentService.updateAllStudent(updateAllStudentsList);

        if(updateStudents == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateStudents);
    }


    // 4. Delete Student Data
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable Long id){  // @PathVariable extracts values from the URL and store them in controller method parameters.

        /*

        Student deletedStudents = studentService.deletingStudent(id);

        if(deletedStudents == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record Deleted");

         */

        Boolean isDeleted = studentService.deletingStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }

}
