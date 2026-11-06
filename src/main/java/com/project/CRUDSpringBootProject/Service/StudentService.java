package com.project.CRUDSpringBootProject.Service;

import com.project.CRUDSpringBootProject.Entity.Student;
import com.project.CRUDSpringBootProject.Repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

// 1. Endpoint listener (/app/students/ POST)

// 2. Business logic ( prepare for key-value pair (JSON), convert it into a database-storable value)

// 3. Interact with db to store

// 4. Respond back to the client.

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createdStudent(Student studentReq){
        System.out.println("Inside Student-Service");
        Student studentResp = studentRepository.save(studentReq); // save() method is used to insert a new record or update an existing record in the database.
        System.out.println("Exiting Student-Service");
        return studentResp;
    }

    public Student getStudent(Long id){

        Optional<Student> studentresp = studentRepository.findById(id); // check record is exist or not

        if(studentresp.isPresent()){
            return studentresp.get(); // get() is a predefined method of Java's Optional class. It is used to retrieve the actual object stored inside an Optional
        }
        return null;
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();  // Get all records
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReqBody){

        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student  studentToSave = existingStudent.get();

        studentToSave.setName(studentReqBody.getName());
        studentToSave.setEmail(studentReqBody.getEmail());
        studentToSave.setAge(studentReqBody.getAge());
        studentToSave.setRollNo(studentReqBody.getRollNo());
        studentToSave.setSubject(studentReqBody.getSubject());

        return studentRepository.save(studentToSave);
    }

    public List<Student> updateAllStudent(List<Student> updateAllStudentsList){

        return studentRepository.saveAll(updateAllStudentsList);

    }

    public boolean deletingStudent(Long id){

        /*

        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student deletedStudent = existingStudent.get();
        studentRepository.deleteById(id);

        return deletedStudent;

         */ // or

        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return false;

        studentRepository.deleteById(id);

        return true;



    }

}
